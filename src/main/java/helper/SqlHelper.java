package helper;

import bean.helper.FilterBeanHelper;
import static java.lang.Math.ceil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqlHelper {

    public static String buildSqlFilter(ArrayList<FilterBeanHelper> alFilter) throws ParseException {
        String strSQLFilter = "";
        if (alFilter != null) {
            for (FilterBeanHelper oFilterBean : alFilter) {
                strSQLFilter += getFilterExpression(oFilterBean);
            }
        }
        return strSQLFilter;
    }

    private static String getFormatDate(String dateIn) throws ParseException {
        SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
        Date date = parseador.parse(dateIn);
        SimpleDateFormat formateador = new SimpleDateFormat("yyy/MM/dd");
        String fecha = formateador.format(date);
        return fecha;
    }

    private static String getFilterExpression(FilterBeanHelper temp) throws ParseException {

        switch (temp.getOperation()) {
            //operations for date ----------------------------------------------
            case "dequa": //equal 
                return temp.getLink() + " " + temp.getField() + " = '" + getFormatDate(temp.getValue()) + "' ";
            case "dnequ": //not equal
                return temp.getLink() + " " + temp.getField() + " != '" + getFormatDate(temp.getValue()) + "' ";
            case "dlowe": //lower than
                return temp.getLink() + " " + temp.getField() + " < '" + getFormatDate(temp.getValue()) + "' ";
            case "dlequ": //lower or equal than
                return temp.getLink() + " " + temp.getField() + " <= '" + getFormatDate(temp.getValue()) + "' ";
            case "dgrea": //greater than
                return temp.getLink() + " " + temp.getField() + " > '" + getFormatDate(temp.getValue()) + "' ";
            case "dgequ": //greater or equal than
                return temp.getLink() + " " + temp.getField() + " >= '" + getFormatDate(temp.getValue()) + "' ";
            //operations for strings -------------------------------------------
            case "sequa": //equal for strings
                return temp.getLink() + " " + temp.getField() + " = '" + temp.getValue() + "' ";
            case "snequ": //not equal for strings
                return temp.getLink() + " " + temp.getField() + " != '" + temp.getValue() + "' ";
            case "slike": //like
                return temp.getLink() + " " + temp.getField() + " LIKE '%" + temp.getValue() + "%' ";
            case "snlik": //not like
                return temp.getLink() + " " + temp.getField() + " NOT LIKE '%" + temp.getValue() + "%' ";
            case "sstar": //starts with
                return temp.getLink() + " " + temp.getField() + " LIKE '" + temp.getValue() + "%' ";
            case "snsta": //not starts with
                return temp.getLink() + " " + temp.getField() + " NOT LIKE '" + temp.getValue() + "%' ";
            case "sends": //ends with
                return temp.getLink() + " " + temp.getField() + " LIKE '%" + temp.getValue() + "' ";
            case "snend": //not ends with
                return temp.getLink() + " " + temp.getField() + " NOT LIKE '%" + temp.getValue() + "' ";
            //operations for numbers -------------------------------------------
            case "nequa": //equal for numbers
                return temp.getLink() + " " + temp.getField() + " = " + temp.getValue() + " ";
            case "nnequ": //not equal for numbers
                return temp.getLink() + " " + temp.getField() + " != " + temp.getValue() + " ";
            case "nlowe": //lower than
                return temp.getLink() + " " + temp.getField() + " < " + temp.getValue() + " ";
            case "nlequ": //lower or equal than
                return temp.getLink() + " " + temp.getField() + " <= " + temp.getValue() + " ";
            case "ngrea": //greater than
                return temp.getLink() + " " + temp.getField() + " > " + temp.getValue() + " ";
            case "ngequ": //greater or equal than
                return temp.getLink() + " " + temp.getField() + " >= " + temp.getValue() + " ";
            //operations for boolean -------------------------------------------
            case "bequa": //equal for boolean
                return temp.getLink() + " " + temp.getField() + " = " + temp.getValue() + " ";
            //------------------------------------------------------------------
            default:
                throw new Error("Filter expression malformed. Operator not valid.");
        }
    }

    public static String buildSqlLimit(Long intTotalRegs, Integer intRegsPerPage, Integer intPageNumber) {
        String SQLLimit = "";
        if (intRegsPerPage > 0 && intRegsPerPage < 10000) {
            if (intPageNumber > 0 && intPageNumber <= (ceil((intTotalRegs / intRegsPerPage) + 1))) {
                SQLLimit = " LIMIT " + (intPageNumber - 1) * intRegsPerPage + " , " + intRegsPerPage;
            } else {
                SQLLimit = " LIMIT 0 ";
            }
        }
        return SQLLimit;
    }

    public static String buildSqlOrder(LinkedHashMap<String, String> hmOrder) {
        String strSQLOrder = "";
        if (hmOrder != null) {
            for (Map.Entry<String, String> entry : hmOrder.entrySet()) {
                strSQLOrder += entry.getKey();
                strSQLOrder += " ";
                strSQLOrder += entry.getValue();
                strSQLOrder += ",";
            }
            strSQLOrder = " ORDER BY " + strSQLOrder.substring(0, strSQLOrder.length() - 1);
        }
        return strSQLOrder;
    }

}

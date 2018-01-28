package bean.genericimplementation;

import com.google.gson.annotations.Expose;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import bean.publicinterface.GenericBeanInterface;
import helper.EncodingHelper;
import helper.EnumHelper;
import helper.Log4jHelper;
import helper.RandomHelper;
import helper.constant.ConfigurationConstants;
import java.lang.reflect.Field;
import java.util.Date;

public abstract class TableGenericBeanImplementation extends ViewGenericBeanImplementation implements GenericBeanInterface {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "ID",
            LongName = "Identificador",
            Description = "Número Identificador de registro",
            IsVisible = true,
            Type = EnumHelper.FieldType.Id
    )
    protected Integer id;

    public TableGenericBeanImplementation() {

    }

    public TableGenericBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getColumns() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                strColumns += x.getName() + ",";
                            }
                        }
                    }
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String getValues() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    x.setAccessible(true);
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.ForeignId) {
                                    strColumns += (Integer) x.get(this) + ",";
                                } else {
                                    if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.Password) {
                                        strColumns += EncodingHelper.quotate("da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04") + ", ";
                                    } else {
                                        if (getTypeFromPropertyMetaData(x) == EnumHelper.FieldType.Token) {
                                            strColumns += EncodingHelper.quotate(RandomHelper.getToken(ConfigurationConstants.tokenSize)) + ", ";
                                        } else {

                                            if (x.getType() == String.class) {
                                                strColumns += EncodingHelper.quotate((String) x.get(this)) + ",";
                                            } else {
                                                if (x.getType() == Date.class) {
                                                    strColumns += EncodingHelper.stringifyAndQuotate((Date) x.get(this)) + ",";
                                                } else {
                                                    if (x.getType() == Integer.class) {
                                                        strColumns += (Integer) x.get(this) + ",";
                                                    } else {
                                                        if (x.getType() == Double.class) {
                                                            strColumns += (Double) x.get(this) + ",";
                                                        } else {
                                                            if (x.getType() == Boolean.class) {
                                                                strColumns += (int) x.get(this) + ",";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    x.setAccessible(false);
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String toPairs() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                if (getTypeFromPropertyMetaData(x) != null) {
                    if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.ForeignObject) {
                            if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Link) {
                                if (getTypeFromPropertyMetaData(x) != EnumHelper.FieldType.Password) {
                                    x.setAccessible(true);
                                    strColumns += x.getName() + "=";
                                    if (x.getType() == String.class) {
                                        strColumns += EncodingHelper.quotate((String) x.get(this)) + ",";
                                    } else {
                                        if (x.getType() == Date.class) {
                                            strColumns += EncodingHelper.stringifyAndQuotate((Date) x.get(this)) + ",";
                                        } else {
                                            if (x.getType() == Integer.class) {
                                                strColumns += (Integer) x.get(this) + ",";
                                            } else {
                                                if (x.getType() == Double.class) {
                                                    strColumns += (Double) x.get(this) + ",";
                                                } else {
                                                    if (x.getType() == Boolean.class) {
                                                        strColumns += (int) x.get(this) + ",";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    x.setAccessible(false);
                                }
                            }
                        }
                    }
                }
            }
            strColumns = strColumns.substring(0, strColumns.length() - 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

}


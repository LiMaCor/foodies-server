package bean.publicinterface;

import bean.helper.MetaBeanHelper;
import java.sql.Connection;
import java.sql.ResultSet;

public interface GenericBeanInterface {

    public String getColumns() throws Exception;

    public String getValues() throws Exception;

    public String toPairs() throws Exception;

    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception;

    public void ComputeCalculatedFields();

}

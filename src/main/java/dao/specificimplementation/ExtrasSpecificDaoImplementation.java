package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class ExtrasSpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public ExtrasSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("extras", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class TipoplatoSpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public TipoplatoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("tipoplato", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

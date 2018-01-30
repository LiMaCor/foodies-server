package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class PlatoSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public PlatoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("plato", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

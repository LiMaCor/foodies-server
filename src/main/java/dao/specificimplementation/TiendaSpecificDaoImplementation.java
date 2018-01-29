package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class TiendaSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public TiendaSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("tienda", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

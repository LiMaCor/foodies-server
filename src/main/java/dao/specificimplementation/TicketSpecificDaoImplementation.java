package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class TicketSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public TicketSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("ticket", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

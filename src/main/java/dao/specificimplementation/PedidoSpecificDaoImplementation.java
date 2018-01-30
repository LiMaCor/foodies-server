package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class PedidoSpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public PedidoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("pedido", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class LineapedidoSpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public LineapedidoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("lineapedido", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}

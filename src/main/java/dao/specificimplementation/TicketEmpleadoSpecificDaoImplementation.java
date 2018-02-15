package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class TicketEmpleadoSpecificDaoImplementation extends TicketSpecificDaoImplementation {

    private Integer idTienda = 0;
    private Integer idUsuario = 0;

    public TicketEmpleadoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);

        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        idUsuario = oUsuario.getId();
        MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
        if (oTipousuario.getId() == 2) {
            String strSQLini = "";

            TiendaSpecificBeanImplementation oTienda = (TiendaSpecificBeanImplementation) oUsuario.getObj_tienda().getBean();
            idTienda = oTienda.getId();
            strSQLini = "FROM ticket where 1=1 "
                    + " AND  id IN (SELECT ti.id FROM pedido p, ticket ti, tienda t"
                    + " WHERE p.id_tienda=" + idTienda
                    + " AND t.id=" + idTienda
                    + " AND ti.id_pedido=p.id) ";            

            strSQL = "SELECT * " + strSQLini;
            strCountSQL = "SELECT COUNT(*) " + strSQLini;
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        }
    }
}

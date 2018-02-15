package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class TicketClienteSpecificDaoImplementation extends TicketSpecificDaoImplementation {

    private Integer idTienda = 0;
    private Integer idUsuario = 0;

    public TicketClienteSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);

        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        idUsuario = oUsuario.getId();
        MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
        if (oTipousuario.getId() == 3) {
            String strSQLini = "";

            TiendaSpecificBeanImplementation oTienda = (TiendaSpecificBeanImplementation) oUsuario.getObj_tienda().getBean();
            idTienda = oTienda.getId();
            strSQLini = "FROM ticket where 1=1 "
                    + " OR  id IN (SELECT distinct ti.id FROM usuario u, tienda t, pedido p, ticket ti"
                    + "                    WHERE u.id_tienda=" + idTienda
                    + "                      AND p.id_usuario=u.id "
                    + "                      AND p.id_tienda=t.id "
                    + "                      AND p.id= ti.id_pedido ) ";

            strSQL = "SELECT * " + strSQLini;
            strCountSQL = "SELECT COUNT(*) " + strSQLini;
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        }
    }
}

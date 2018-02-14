package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class TicketEmpleadoSpecificDaoImplementation extends TicketSpecificDaoImplementation {

    private Integer idPedido = 1; // trampa
    private Integer idUsuario = 0;

    public TicketEmpleadoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);

        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        idUsuario = oUsuario.getId();
        MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
        if (oTipousuario.getId() == 2) {
            String strSQLini = "";

            
            strSQLini = "FROM ticket where 1=1 "
                    + "AND (id IN (SELECT distinct id FROM ticket where id_pedido = " + idPedido + " and id_tipousuario=3 ) "
                    + " OR  id IN (SELECT distinct ti.id FROM ticket ti, pedido p, usuario u "
                    + "                    WHERE u.id_tipousuario=3 "
                    + "                      AND u.id=p.id_usuario "
                    + "                      AND ti.id_pedido= " + idPedido + ")"
                    + ") ";

            strSQL = "SELECT * " + strSQLini;

            strCountSQL = "SELECT COUNT(*) " + strSQLini;
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        }
    }
}

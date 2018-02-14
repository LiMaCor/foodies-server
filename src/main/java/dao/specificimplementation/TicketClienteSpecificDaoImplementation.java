package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class TicketClienteSpecificDaoImplementation extends TicketSpecificDaoImplementation {

    private Integer idPedido = 1; // trampa
    private Integer idUsuario = 0;

    public TicketClienteSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);

        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        idUsuario = oUsuario.getId();
        MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
        if (oTipousuario.getId() == 3) {
            String strSQLini = "";

            
            strSQLini = "FROM ticket where 1=1 "
                    + "AND id_pedido= " + idPedido;

            strSQL = "SELECT * " + strSQLini;

            strCountSQL = "SELECT COUNT(*) " + strSQLini;
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        }

    }
}

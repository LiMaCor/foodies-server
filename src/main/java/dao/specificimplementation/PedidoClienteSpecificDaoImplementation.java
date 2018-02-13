package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class PedidoClienteSpecificDaoImplementation extends PedidoSpecificDaoImplementation {

    private Integer idTienda = 0;
    private Integer idUsuario = 0;

    public PedidoClienteSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);
        if (oPuserBean_security != null) {

            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();          
            if (oTipousuario.getId() == 3) {
                String strSQLini = "";

                TiendaSpecificBeanImplementation oTienda = (TiendaSpecificBeanImplementation) oUsuario.getObj_tienda().getBean();
                idTienda = oTienda.getId();
                strSQLini = "FROM pedido where 1=1 "
                        + "AND id_usuario=" + idUsuario
                        + " AND id_tienda= " + idTienda;
                strSQL = "SELECT * " + strSQLini;
                strCountSQL = "SELECT COUNT(*) " + strSQLini;
                if (strWhere != null) {
                    strSQL += " " + strWhere + " ";
                    strCountSQL += " " + strWhere + " ";
                }
            }
        }
    }

}

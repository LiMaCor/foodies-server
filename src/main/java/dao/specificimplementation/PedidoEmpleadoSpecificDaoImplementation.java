package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class PedidoEmpleadoSpecificDaoImplementation extends PedidoSpecificDaoImplementation {

    private Integer idTienda = 0;
    private Integer idUsuario = 0;

    public PedidoEmpleadoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);
        if (oPuserBean_security != null) {

            UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
            idUsuario = oUsuario.getId();
            MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
            TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
            if (oTipousuario.getId() == 2) {
                String strSQLini = "";

                TiendaSpecificBeanImplementation oTienda = (TiendaSpecificBeanImplementation) oUsuario.getObj_tienda().getBean();
                idTienda = oTienda.getId();
                strSQLini = "FROM pedido where 1=1 "
                        + " AND id_tienda= " + idTienda
                        + " OR  id IN (SELECT distinct u.id FROM pedido p, usuario u "
                        + "                    WHERE u.id_tipousuario=3 "
                        + "                      AND u.id=p.id_usuario "
                        + "                      AND p.id_tienda= " + idTienda + ") ";
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

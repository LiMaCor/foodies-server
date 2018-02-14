package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;

public class LineapedidoEmpleadoSpecificDaoImplementation extends LineapedidoSpecificDaoImplementation {

    private Integer idLinpedido = 1; // trampa
    private Integer idUsuario = 0;

    public LineapedidoEmpleadoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super(oPooledConnection, oPuserBean_security, strWhere);

        UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
        idUsuario = oUsuario.getId();
        MetaBeanHelper ombhTipousuario = (MetaBeanHelper) oUsuario.getObj_tipousuario();
        TipousuarioSpecificBeanImplementation oTipousuario = (TipousuarioSpecificBeanImplementation) ombhTipousuario.getBean();
        if (oTipousuario.getId() == 2) {
            String strSQLini = "";


            strSQLini = "FROM lineapedido where 1=1 "
                    + "AND id_pedido=" + idLinpedido;

            strCountSQL = "SELECT COUNT(*) " + strSQLini;
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        }

    }
}

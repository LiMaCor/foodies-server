package factory;

import java.sql.Connection;
import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import dao.publicinterface.MetaDaoInterface;
import dao.specificimplementation.ExtrasClienteSpecificDaoImplementation;
import dao.specificimplementation.ExtrasEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.ExtrasSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoClienteSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoSpecificDaoImplementation;
import dao.specificimplementation.PedidoClienteSpecificDaoImplementation;
import dao.specificimplementation.PedidoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.PedidoSpecificDaoImplementation;
import dao.specificimplementation.PlatoSpecificDaoImplementation;
import dao.specificimplementation.TicketClienteSpecificDaoImplementation;
import dao.specificimplementation.TicketEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TicketSpecificDaoImplementation;
import dao.specificimplementation.TiendaSpecificDaoImplementation;
import dao.specificimplementation.TipoplatoSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioClienteSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import dao.specificimplementation.UsuarioClienteSpecificDaoImplementation;
import dao.specificimplementation.UsuarioEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.UsuarioSpecificDaoImplementation;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new UsuarioEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new UsuarioClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "tipousuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TipousuarioEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TipousuarioClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "tienda":
                oDao = (MetaDaoInterface) new TiendaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "ticket":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TicketSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TicketSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TicketEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TicketClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "tipoplato":
                oDao = (MetaDaoInterface) new TipoplatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "plato":
                oDao = (MetaDaoInterface) new PlatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "pedido":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new PedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new PedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new PedidoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new PedidoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "lineapedido":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new LineapedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new LineapedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new LineapedidoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new LineapedidoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "extras":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new ExtrasSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new ExtrasSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new ExtrasEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new ExtrasClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }
}

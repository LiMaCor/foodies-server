package factory;

import bean.helper.ReplyBeanHelper;
import helper.EncodingHelper;
import service.specificimplementation.TipousuarioSpecificServiceImplementation;
import service.specificimplementation.UsuarioSpecificServiceImplementation;
import javax.servlet.http.HttpServletRequest;
import service.specificimplementation.TicketSpecificServiceImplementation;
import service.specificimplementation.TiendaSpecificServiceImplementation;
import service.specificimplementation.TipoplatoSpecificServiceImplementation;

public class ServiceFactory {

    public static ReplyBeanHelper executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBeanHelper oReplyBean = null;
        switch (ob) {
            case "usuario":
                UsuarioSpecificServiceImplementation oUsuarioService = new UsuarioSpecificServiceImplementation(oRequest);
                switch (op) {

                    case "getallobjectsmetadata":
                        oReplyBean = oUsuarioService.getallobjectsmetadata();
                        break;
                    case "getmetadata":
                        oReplyBean = oUsuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oUsuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oUsuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getCount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "getsessionstatus":
                        oReplyBean = oUsuarioService.getSessionStatus();
                        break;
                    case "getcountx":
                        oReplyBean = oUsuarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oUsuarioService.getPageX();
                        break;
                    case "setpass":
                        oReplyBean = oUsuarioService.setPass();
                        break;
                    case "getsessionuserlevel":
                        oReplyBean = oUsuarioService.getSessionUserLevel();
                        break;
                    case "checklogin":
                        oReplyBean = oUsuarioService.checklogin();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "tipousuario":
                TipousuarioSpecificServiceImplementation oTipousuarioService = new TipousuarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipousuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipousuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipousuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipousuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipousuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipousuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipousuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipousuarioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "tienda":
                TiendaSpecificServiceImplementation oTiendaService = new TiendaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTiendaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTiendaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTiendaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTiendaService.get();
                        break;
                    case "set":
                        oReplyBean = oTiendaService.set();
                        break;
                    case "remove":
                        oReplyBean = oTiendaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTiendaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTiendaService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "ticket":
                TicketSpecificServiceImplementation oTicketService = new TicketSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTicketService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTicketService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTicketService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTicketService.get();
                        break;
                    case "set":
                        oReplyBean = oTicketService.set();
                        break;
                    case "remove":
                        oReplyBean = oTicketService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTicketService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTicketService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            case "tipoplato":
                TipoplatoSpecificServiceImplementation oTipoplatoService = new TipoplatoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipoplatoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipoplatoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipoplatoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipoplatoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipoplatoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipoplatoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipoplatoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipoplatoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;

            default:
                oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Object not found : Please contact your administrator"));
                break;
        }
        return oReplyBean;
    }
}

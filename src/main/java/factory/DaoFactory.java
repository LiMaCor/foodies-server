package factory;

import java.sql.Connection;
import bean.helper.MetaBeanHelper;
import dao.publicinterface.MetaDaoInterface;
import dao.specificimplementation.TicketSpecificDaoImplementation;
import dao.specificimplementation.TiendaSpecificDaoImplementation;
import dao.specificimplementation.TipoplatoSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import dao.specificimplementation.UsuarioSpecificDaoImplementation;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipousuario":
                oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tienda":
                oDao = (MetaDaoInterface) new TiendaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "ticket":
                oDao = (MetaDaoInterface) new TicketSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipoplato":
                oDao = (MetaDaoInterface) new TipoplatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;

            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }
}

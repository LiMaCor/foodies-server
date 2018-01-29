package factory;

import java.sql.Connection;
import bean.helper.MetaBeanHelper;
import dao.publicinterface.MetaDaoInterface;
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
                default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }
}

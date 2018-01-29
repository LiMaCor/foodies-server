package factory;

import bean.helper.MetaBeanHelper;
import bean.publicinterface.GenericBeanInterface;
import bean.specificimplementation.TicketSpecificBeanImplementation;
import bean.specificimplementation.TiendaSpecificBeanImplementation;
import bean.specificimplementation.TipoplatoSpecificBeanImplementation;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;

public class BeanFactory {

    public static GenericBeanInterface getBean(String ob, MetaBeanHelper oPuserBean_security) {
        GenericBeanInterface oBean = null;
        MetaBeanHelper oPuserSecurity = oPuserBean_security; //para rangos de acceso
        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
            case "tienda":
                oBean = new TiendaSpecificBeanImplementation();
                break;
            case "ticket":
                oBean = new TicketSpecificBeanImplementation();
                break;
            case "tipoplato":
                oBean = new TipoplatoSpecificBeanImplementation();
                break;
                
            default:
                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}

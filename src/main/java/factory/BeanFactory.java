package factory;

import bean.helper.MetaBeanHelper;
import bean.publicinterface.GenericBeanInterface;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;

public class BeanFactory {

    public static GenericBeanInterface getBean(String ob, MetaBeanHelper oPuserBean_security) {
        GenericBeanInterface oBean = null;
        MetaBeanHelper oPuserSecurity = oPuserBean_security;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
                
            default:
                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}

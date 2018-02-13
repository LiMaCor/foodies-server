package dao.specificimplementation;

import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;


public class TipoplatoClienteSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public TipoplatoClienteSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("tipoplato", oPooledConnection, oPuserBean_security, strWhere);
    }
    
        @Override
    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
        return 0;
    }

    @Override
    public int remove(Integer id) throws Exception {
        return 0;
    }
}

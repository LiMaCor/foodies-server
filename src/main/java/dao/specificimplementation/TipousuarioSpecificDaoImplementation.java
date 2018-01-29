package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class TipousuarioSpecificDaoImplementation extends TableGenericDaoImplementation {

    public TipousuarioSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("tipousuario", oPooledConnection, oPuserBean_security, strWhere);
    }
}

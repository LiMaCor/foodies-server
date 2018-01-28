package connection.specificimplementation;

import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.SQLException;

public class DriverManagerConnection implements ConnectionInterface {

    private Connection oConnection;

    @Override
    public Connection newConnection() throws Exception {
        oConnection = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = ConnectionConstants.getConnectionChain();
            oConnection = (java.sql.DriverManager.getConnection(urlOdbc, ConnectionConstants.databaseLogin, ConnectionConstants.databasePassword));
            return oConnection;
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }

    @Override
    public void disposeConnection() throws Exception {
        try {
            if (oConnection != null) {
                oConnection.close();
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }

}

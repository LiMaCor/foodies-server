package connection.specificimplementation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3POConnection implements ConnectionInterface {

    private ComboPooledDataSource connectionPool = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {
        try {
            connectionPool = new ComboPooledDataSource();
            connectionPool.setDriverClass("com.mysql.jdbc.Driver");
            connectionPool.setJdbcUrl(ConnectionConstants.getConnectionChain());
            connectionPool.setUser(ConnectionConstants.databaseLogin);
            connectionPool.setPassword(ConnectionConstants.databasePassword);
            connectionPool.setMaxStatements(180);
            oConnection = connectionPool.getConnection();
        } catch (PropertyVetoException | SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oConnection;
    }

    @Override
    public void disposeConnection() throws Exception {
        try {
            if (oConnection != null) {
                oConnection.close();
            }
            if (connectionPool != null) {
                connectionPool.close();
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }
}


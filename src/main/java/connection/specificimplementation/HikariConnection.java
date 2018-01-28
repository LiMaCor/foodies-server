package connection.specificimplementation;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnection implements ConnectionInterface {

    private HikariDataSource oConnectionPool = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(ConnectionConstants.getConnectionChain());
        config.setUsername(ConnectionConstants.databaseLogin);
        config.setPassword(ConnectionConstants.databasePassword);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setLeakDetectionThreshold(15000);
        config.setConnectionTestQuery("SELECT 1");
        config.setConnectionTimeout(2000);
        try {
            oConnectionPool = new HikariDataSource(config);
            oConnection = oConnectionPool.getConnection();
        } catch (SQLException ex) {
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
            if (oConnectionPool != null) {
                oConnectionPool.close();
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }
}

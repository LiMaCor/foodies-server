package connection.specificimplementation;

import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DBCPConnection implements ConnectionInterface {

    private BasicDataSource dataSource = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {
        try {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername(ConnectionConstants.databaseLogin);
            dataSource.setPassword(ConnectionConstants.databasePassword);
            dataSource.setUrl(ConnectionConstants.getConnectionChain());
            dataSource.setValidationQuery("select 1");
            dataSource.setMaxActive(100);
            dataSource.setMaxWait(10000);
            dataSource.setMaxIdle(10);
            oConnection = dataSource.getConnection();
        } catch (Exception ex) {
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
            if (dataSource != null) {
                dataSource.close();
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }
}


package connection.specificimplementation;

import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.SQLException;
import org.vibur.dbcp.ViburDBCPDataSource;
import org.vibur.dbcp.ViburDBCPException;

public class ViburConnection implements ConnectionInterface {

    private ViburDBCPDataSource dataSource = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {

        try {

            dataSource = new ViburDBCPDataSource();

            dataSource.setJdbcUrl(ConnectionConstants.getConnectionChain());
            dataSource.setUsername(ConnectionConstants.databaseLogin);
            dataSource.setPassword(ConnectionConstants.databasePassword);

            dataSource.setPoolInitialSize(10);
            dataSource.setPoolMaxSize(100);

            dataSource.setConnectionIdleLimitInSeconds(30);
            dataSource.setTestConnectionQuery("isValid");

            dataSource.setLogQueryExecutionLongerThanMs(500);
            dataSource.setLogStackTraceForLongQueryExecution(true);

            dataSource.start();
            oConnection = dataSource.getConnection();

        } catch (SQLException | ViburDBCPException ex) {
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

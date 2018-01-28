package connection.specificimplementation;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import connection.publicinterface.ConnectionInterface;
import helper.constant.ConnectionConstants;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.SQLException;

public class BoneCPConnection implements ConnectionInterface {

    private BoneCP connectionPool = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {
        try {
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl(ConnectionConstants.getConnectionChain());
            config.setUsername(ConnectionConstants.databaseLogin);
            config.setPassword(ConnectionConstants.databasePassword);
            config.setMinConnectionsPerPartition(1);
            config.setMaxConnectionsPerPartition(3);
            config.setPartitionCount(1);
            connectionPool = new BoneCP(config);
            oConnection = connectionPool.getConnection();
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


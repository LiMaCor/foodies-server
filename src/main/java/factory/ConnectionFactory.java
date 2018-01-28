package factory;

import connection.specificimplementation.C3POConnection;
import connection.publicinterface.ConnectionInterface;
import connection.specificimplementation.BoneCPConnection;
import connection.specificimplementation.DBCPConnection;
import connection.specificimplementation.DriverManagerConnection;
import connection.specificimplementation.HikariConnection;
import connection.specificimplementation.ViburConnection;

public class ConnectionFactory {

    public static ConnectionInterface getSourceConnection(String strConnection) throws Exception {
        ConnectionInterface oDataConnectionSource = null;
        switch (strConnection) {
            case "hikari":
                oDataConnectionSource = new HikariConnection();
                break;
            case "vibur":
                oDataConnectionSource = new ViburConnection();
                break;
            case "c3po":
                oDataConnectionSource = new C3POConnection();
                break;
            case "dbcp":
                oDataConnectionSource = new DBCPConnection();
                break;
            case "driver":
                oDataConnectionSource = new DriverManagerConnection();
                break;
            case "bone":
                oDataConnectionSource = new BoneCPConnection();
                break;
            default:
                break;
        }

        return oDataConnectionSource;
    }

}

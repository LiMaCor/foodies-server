package helper.constant;

public class ConnectionConstants {

    public static final String connectionName = "hikari";
    public static final String databaseName = "foodies";
    public static final String databaseLogin = "root";
    public static final String databasePassword = "bitnami";
    public static final String databasePort = "3306";
    public static final String databaseIP = "127.0.0.1";

    public static String getConnectionChain() {
        return "jdbc:mysql://" + ConnectionConstants.databaseIP + ":" + ConnectionConstants.databasePort + "/" + ConnectionConstants.databaseName;
    }

}
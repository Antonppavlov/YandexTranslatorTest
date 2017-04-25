package su.bbrain.www.yandextranslator.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLiteConnection {

    private static Connection connection;
    private static String driverClassName;
    private static String urlConnection;


    public static void init(String driverClass, String url) {
        driverClassName = driverClass;
        urlConnection = url;

        createConnection();
    }

    private static void createConnection() {
        try {
            Class.forName(driverClassName).newInstance();

            if (connection == null) {
                connection = DriverManager.getConnection(urlConnection);
                connection.createStatement().execute("PRAGMA foreign_keys = ON");
                connection.createStatement().execute("PRAGMA encoding = \"UTF-8\"");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }


}

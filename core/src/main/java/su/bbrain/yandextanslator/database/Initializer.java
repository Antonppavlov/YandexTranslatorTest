package su.bbrain.yandextanslator.database;


import java.sql.SQLException;

import su.bbrain.yandextanslator.dao.WordDAO;

public class Initializer {

    private static WordDAO wordDAO;

    public static void load(String driverClass, String url) throws SQLException {
        SQLiteConnection.init(driverClass, url);
        wordDAO = new WordDAO();
    }

    public static WordDAO getWordDAO() {
        return wordDAO;
    }
}

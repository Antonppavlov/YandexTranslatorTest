package su.bbrain.yandextranslator.app;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import su.bbrain.yandextanslator.database.Initializer;


public class DbConnection {

    private static final String TAG = AppContext.class.getName();

    private static final String DB_NAME = "translator.db";
    private static final String DRIVER_CLASS = "org.sqldroid.SQLDroidDriver";

    private static String dbFolder;
    private static String dbPath;

    private DbConnection() {
    }

    public static void initConnection(Context context) throws SQLException {
        checkDbExist(context);
        Initializer.load(DRIVER_CLASS,"jdbc:sqldroid:"+dbPath);
    }


    private static void checkDbExist(Context context) {

        // определить папку с данными приложения
        dbFolder = context.getApplicationInfo().dataDir + "/" + "databases/";

        dbPath = dbFolder + DB_NAME;

        if (!checkDataBaseExists()) {
            copyDataBase(context);
        }
    }

    private static void copyDataBase(Context context) {
        // создаем папку databases
        File databaseFolder = new File(dbFolder);
        databaseFolder.mkdir();


        try (InputStream sourceFile = context.getAssets().open(DB_NAME); // что копируем
             OutputStream destinationFolder = new FileOutputStream(dbPath); // куда копируем
        ) {

            // копируем по байтам весь файл стандартным способом Java I/O
            byte[] buffer = new byte[1024];
            int length;
            while ((length = sourceFile.read(buffer)) > 0) {
                destinationFolder.write(buffer, 0, length);
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }


    private static boolean checkDataBaseExists() {
        File dbFile = new File(dbPath);
        return dbFile.exists();
    }
}

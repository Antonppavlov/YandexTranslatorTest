package su.bbrain.yandextranslator.app;

import android.app.Application;


/**
 * будем запускаться 1 раз при каждом запуске приложения
 * производить одно действие
 * копирует файл базы данных в определенную папку
 * чтобы у приложения был доступ к бд
 **/
public class AppContext extends Application {

    /**
     * если нет файла БД - скопировать его из папки assets
     **/
    @Override
    public void onCreate() {
        super.onCreate();
    }

}

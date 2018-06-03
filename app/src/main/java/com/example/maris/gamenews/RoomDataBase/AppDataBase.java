package com.example.maris.gamenews.RoomDataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.maris.gamenews.Class.User;
import com.example.maris.gamenews.Interface.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao userDao();
    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabse(final Context context){

        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    // Creación de la base de datos
                    AppDataBase mydb = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class, "database-name").build();
                }
            }
        }
        return INSTANCE;
    }


}


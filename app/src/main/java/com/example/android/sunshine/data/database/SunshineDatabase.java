package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Room Database abstract class that initializes the database
 * with the Entities and the DAOs specified
 *
 * @author Kaushik N Sanji
 */
@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class SunshineDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "weather";
    private static SunshineDatabase INSTANCE;

    public static SunshineDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SunshineDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SunshineDatabase.class,
                            DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WeatherDao weatherDao();
}

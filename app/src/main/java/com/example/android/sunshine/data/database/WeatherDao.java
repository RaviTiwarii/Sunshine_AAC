package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

/**
 * Data Access Object Interface for reading from and writing to database
 *
 * @author Kaushik N Sanji
 */
@Dao
public interface WeatherDao {
    //Bulk Insert operation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    //Gets the weather data for the given day
    @Query("SELECT * FROM weather WHERE date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    //Gets the number of days of future weather forecasts available from the given day
    @Query("SELECT COUNT(1) FROM weather WHERE date >= :date")
    int countAllFutureWeather(Date date);

    //Deletes weather data older than the given day
    @Query("DELETE FROM weather WHERE date < :date")
    void deleteOldData(Date date);

    //Gets the Forecast available from the given day
    @Query("SELECT id, weatherIconId, date, max, min FROM weather WHERE date >= :date")
    LiveData<List<ListViewWeatherEntry>> getForecastFrom(Date date);
}

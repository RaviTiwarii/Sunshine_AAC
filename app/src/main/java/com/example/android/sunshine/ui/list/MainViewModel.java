package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.ListViewWeatherEntry;

import java.util.List;

/**
 * {@link ViewModel} for {@link MainActivity}
 *
 * @author Kaushik N Sanji
 */
public class MainViewModel extends ViewModel {

    private final LiveData<List<ListViewWeatherEntry>> mForecastData;

    public MainViewModel(SunshineRepository repository) {
        mForecastData = repository.getForecastFromToday();
    }

    public LiveData<List<ListViewWeatherEntry>> getForecastData() {
        return mForecastData;
    }
}

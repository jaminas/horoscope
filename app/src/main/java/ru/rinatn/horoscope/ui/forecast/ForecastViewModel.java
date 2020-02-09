package ru.rinatn.horoscope.ui.forecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import ru.rinatn.horoscope.model.Forecast;
import ru.rinatn.horoscope.service.ForecastService;

public class ForecastViewModel extends ViewModel
{
    MutableLiveData<Forecast> forecast;

    public LiveData<Forecast> getData()
    {
        if (forecast == null)
        {
            forecast = new MutableLiveData<>();
            loadData();
        }
        return forecast;
    }

    private void loadData()
    {

        forecast.postValue(ForecastService.get(1));

        /*
        dataRepository.loadData(new Callback<Forecast>()
        {
            @Override
            public void onLoad(Forecast s) {
                forecast.postValue(s);
            }
        });*/
    }
}

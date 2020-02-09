package ru.rinatn.horoscope.ui.forecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import ru.rinatn.horoscope.model.Forecast;

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
        Forecast fore = new Forecast();
        fore.setId(1509);
        fore.setZodiac_id(1);
        fore.setCategory_id(1);
        fore.setLocale_id(3);
        fore.setForecast_type_id(1);
        fore.setDate(new Date());
        fore.setText("You may not feel in sync with the day's energy, Aries. Something about it may not sit right with you. Your natural instinct to want to take the lead may be overshadowed by an unwillingness to even get up. You may feel like your internal fire is squelched, especially when it comes to love and beauty. If your mind is cloudy, don't worry about it. The fog will clear soon.");

        forecast.postValue(fore);

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

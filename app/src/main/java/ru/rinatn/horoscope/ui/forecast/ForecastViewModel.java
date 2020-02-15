package ru.rinatn.horoscope.ui.forecast;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.rinatn.horoscope.model.Forecast;
import ru.rinatn.horoscope.model.api.ForecastJson;
import ru.rinatn.horoscope.service.ApiService;
import ru.rinatn.horoscope.service.ZodiacService;

public class ForecastViewModel extends ViewModel implements Callback<List<ForecastJson>>
{
    MutableLiveData<Forecast> ld_forecast;

    int zodiac_id = 1;

    static final int LOCALE_ID = 3;

    static final int CATEGORY_ID = 1;

    static final int TYPE_ID = 1;

    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    static final SimpleDateFormat SDFO = new SimpleDateFormat("yyyy-M-d");

    public LiveData<Forecast> getData()
    {
        if (ld_forecast == null)
        {
            ld_forecast = new MutableLiveData<>();
            ApiService api_service = new ApiService();
            Call<List<ForecastJson>> fcall = api_service.getForecasts(new Date(), LOCALE_ID, zodiac_id);
            fcall.enqueue(this);
        }
        return ld_forecast;
    }

    @Override
    public void onResponse(Call<List<ForecastJson>> call, Response<List<ForecastJson>> response)
    {
        if(response.isSuccessful())
        {
            Date cur_date = new Date();
            for(ForecastJson fore : response.body())
            {
                Log.i("RLOG", fore.toString());

                Date for_date = this.getDate(fore.getDate());
                if (
                    fore.getCategory_id() == CATEGORY_ID
                    && fore.getForecast_type_id() == TYPE_ID
                    && SDF.format(cur_date).equals(SDF.format(for_date))
                ) {
                    Forecast forecast = new Forecast();
                    forecast.setDate(for_date);
                    forecast.setZodiac(ZodiacService.get(zodiac_id));
                    forecast.setText(fore.getText());
                    forecast.setBiorhythm(fore.getBiorhythm());

                    ld_forecast.postValue(forecast);

                    Log.i("RLOG", forecast.toString());
                    break;
                }
            }

        }
        else
        {
            Log.w("RLOG", "Request isn't successfull. " + response.errorBody().toString());

        }
    }

    @Override
    public void onFailure(Call<List<ForecastJson>> call, Throwable t)
    {
        Log.w("RLOG", "Request on Falure. " + t.toString());
    }

    Date getDate(String date)
    {
        Date rdate = null;
        try {
            rdate = SDF.parse(date);
        } catch (ParseException e) {
            try {
                rdate = SDFO.parse(date);
            } catch (ParseException ex) {
                Log.w("RLOG", "New unparsed format date: " + date);
            }
        }
        return rdate;
    }
}

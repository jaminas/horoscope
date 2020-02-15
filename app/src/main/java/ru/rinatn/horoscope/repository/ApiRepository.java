package ru.rinatn.horoscope.repository;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.rinatn.horoscope.model.api.ForecastJson;

public interface ApiRepository
{
    @GET("forecast")
    Call<List<ForecastJson>> getForecasts(
            @Query("date") String date,
            @Query("locale_id") int locale_id,
            @Query("zodiac_id") int zodiac_id
    );
}

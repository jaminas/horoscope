package ru.rinatn.horoscope.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.rinatn.horoscope.model.api.ForecastJson;
import ru.rinatn.horoscope.repository.ApiRepository;

public class ApiService
{
    static final String BASE_URL = "http://v2.horoscopus.review/api/v1/";

    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    Retrofit retrofit;
    ApiRepository api_repository;

    public ApiService()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        api_repository = retrofit.create(ApiRepository.class);

    }

    public Call<List<ForecastJson>> getForecasts(Date date, int locale_id, int zodiac_id)
    {
        return api_repository.getForecasts(SDF.format(date), locale_id, zodiac_id);
    }

}

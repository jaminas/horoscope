package ru.rinatn.horoscope.model.api;

import lombok.Data;

@Data
public class ForecastJson
{
    int id;

    int zodiac_id;

    int category_id;

    int locale_id;

    int forecast_type_id;

    String date;

    String text;

    String biorhythm;

    public String toString()
    {
        return this.getClass().getSimpleName() + " " +
                "ID: " + id + "; " +
                "date: " + date + "; " +
                "category_id: " + category_id + "; " +
                "locale_id: " + locale_id + "; " +
                "forecast_type_id: " + forecast_type_id + "; " +
                "zodiac_id: " + zodiac_id;
    }
}

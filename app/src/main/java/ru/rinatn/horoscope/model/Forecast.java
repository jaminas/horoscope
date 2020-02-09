package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Data;

@Data
public class Forecast
{
    int id;

    int zodiac_id;

    int category_id;

    int locale_id;

    int forecast_type_id;

    Date date;

    String text;

    String biorhythm;
}

package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Data;

@Data
public class Forecast
{
    Zodiac zodiac;

    Date date;

    String text;

    String biorhythm;

    public String toString()
    {
        return this.getClass().getSimpleName() + " " +
                "date: " + date + "; " +
                "zodiac: " + zodiac.toString();
    }
}

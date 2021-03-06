package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class Zodiac
{
    int id;

    String title_ru;

    String title_en;

    public Zodiac(int id, String title_ru, String title_en)
    {
        this.id = id;
        this.title_ru = title_ru;
        this.title_en = title_en;
    }

    public String toString()
    {
        return this.getClass().getSimpleName() + " ID: " + id + "; title: " + title_ru;
    }
}

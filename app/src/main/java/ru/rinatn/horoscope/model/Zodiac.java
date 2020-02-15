package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class Zodiac
{
    int id;

    String title;

    public Zodiac(int id, String tistle)
    {
        this.id = id;
        this.title = title;
    }

    public String toString()
    {
        return this.getClass().getSimpleName() + " ID: " + id + "; title: " + title;
    }
}

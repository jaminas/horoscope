package ru.rinatn.horoscope.model;

import lombok.Data;

@Data
public class Relationship
{
    int id;

    String title_ru;

    String title_en;

    public Relationship(int id, String title_ru, String title_en)
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

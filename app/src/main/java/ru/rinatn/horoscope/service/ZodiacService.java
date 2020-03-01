package ru.rinatn.horoscope.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import ru.rinatn.horoscope.model.Zodiac;

public class ZodiacService
{

    private static final List<Zodiac> store = new ArrayList()
    {{
        this.add(new Zodiac(1,  "Овен", ""));
        this.add(new Zodiac(2,  "Телец", ""));
        this.add(new Zodiac(3,  "Близнецы", ""));
        this.add(new Zodiac(4,  "Рак", ""));
        this.add(new Zodiac(5,  "Лев", ""));
        this.add(new Zodiac(6,  "Дева", ""));
        this.add(new Zodiac(7,  "Весы", ""));
        this.add(new Zodiac(8,  "Скорпион", ""));
        this.add(new Zodiac(9,  "Стрелец", ""));
        this.add(new Zodiac(10, "Козерог", ""));
        this.add(new Zodiac(11, "Водолей", ""));
        this.add(new Zodiac(12, "Рыбы", ""));

    }};

    public static Zodiac get(int id)
    {
        return store.get(id - 1);
    }

    public static List<Zodiac> getAll()
    {
        return store;
    }

    public static String[] getValues()
    {
        List<String> result = new ArrayList();
        for(Zodiac item : store)
        {
            result.add(item.getTitle_ru());
        }

        return result.toArray(new String[result.size()]);
    }

}

package ru.rinatn.horoscope.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.rinatn.horoscope.model.Sex;
import ru.rinatn.horoscope.model.Zodiac;

public class SexService
{
    private static final List<Sex> store = new ArrayList()
    {{
        this.add(new Sex(1, "Мужчина", "Male"));
        this.add(new Sex(2, "Женщина", "Female"));

    }};

    public static Sex get(int id)
    {
        return store.get(id - 1);
    }

    public static List<Sex> getAll()
    {
        return store;
    }

    public static String[] getValues()
    {
        List<String> result = new ArrayList();
        for(Sex item : store)
        {
            result.add(item.getTitle_ru());
        }

        return result.toArray(new String[result.size()]);
    }

}

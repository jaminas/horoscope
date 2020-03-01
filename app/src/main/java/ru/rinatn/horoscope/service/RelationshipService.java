package ru.rinatn.horoscope.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.rinatn.horoscope.model.Relationship;
import ru.rinatn.horoscope.model.Zodiac;

public class RelationshipService
{
    private static final List<Relationship> store = new ArrayList()
    {{
        this.add(new Relationship(1, "Одинокий(ая)", "Single"));
        this.add(new Relationship(2, "Женат/Замужем", "Married"));
        this.add(new Relationship(3, "Разведен(а)", "Divorced"));
        this.add(new Relationship(4, "В отношениях", "Relationship"));

    }};

    public static Relationship get(int id)
    {
        return store.get(id - 1);
    }

    public static List<Relationship> getAll()
    {
        return store;
    }

    public static String[] getValues()
    {
        List<String> result = new ArrayList();
        for(Relationship item : store)
        {
            result.add(item.getTitle_ru());
        }

        return result.toArray(new String[result.size()]);
    }

}

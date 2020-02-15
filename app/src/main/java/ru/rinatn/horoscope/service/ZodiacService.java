package ru.rinatn.horoscope.service;

import java.util.HashMap;
import ru.rinatn.horoscope.model.Zodiac;

public class ZodiacService
{
    private static final HashMap<Integer, Zodiac> zodiacs = new HashMap()
    {{
        this.put(1,  new Zodiac(1, "Овен"));
        this.put(2,  new Zodiac(2,  "Телец"));
        this.put(3,  new Zodiac(3,  "Близнецы"));
        this.put(4,  new Zodiac(4,  "Рак"));
        this.put(5,  new Zodiac(5,  "Лев"));
        this.put(6,  new Zodiac(6,  "Дева"));
        this.put(7,  new Zodiac(7,  "Весы"));
        this.put(8,  new Zodiac(8,  "Скорпион"));
        this.put(9,  new Zodiac(9,  "Стрелец"));
        this.put(10, new Zodiac(10, "Козерог"));
        this.put(11, new Zodiac(11, "Водолей"));
        this.put(12, new Zodiac(12, "Рыбы"));

    }};

    public static Zodiac get(int id)
    {
        return zodiacs.containsKey(id) ? zodiacs.get(id) : null;
    }

}

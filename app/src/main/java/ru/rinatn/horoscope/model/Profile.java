package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Data;
import ru.rinatn.horoscope.model.enums.Relationship;
import ru.rinatn.horoscope.model.enums.Sex;

@Data
public class Profile
{
    String username;

    Date birthdate;

    Integer birthhour;

    Integer birthminute;

    Sex sex;

    Relationship relationship;

    Integer country_id;

}

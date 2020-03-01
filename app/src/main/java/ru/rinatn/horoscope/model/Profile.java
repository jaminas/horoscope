package ru.rinatn.horoscope.model;

import java.util.Date;

import lombok.Data;

@Data
public class Profile
{
    String username;

    Date birthdate;

    Integer birthhour;

    Integer birthminute;

    Integer zodiac;

    Integer sex;

    Integer relationship;

    Integer country_id;

}

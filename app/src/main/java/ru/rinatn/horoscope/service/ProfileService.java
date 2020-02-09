package ru.rinatn.horoscope.service;

import java.util.Date;

import ru.rinatn.horoscope.model.Profile;
import ru.rinatn.horoscope.model.enums.Relationship;
import ru.rinatn.horoscope.model.enums.Sex;

public class ProfileService
{
    public static Profile get()
    {
        Profile profile = null;

        profile = new Profile();
        profile.setUsername("Константин Константинопольский");
        profile.setBirthdate(new Date());
        profile.setBirthhour(10);
        profile.setBirthminute(30);
        profile.setSex(Sex.male);
        profile.setRelationship(Relationship.single);

        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoaderActivity.this);
        //if (preferences)

        return profile;
    }
}

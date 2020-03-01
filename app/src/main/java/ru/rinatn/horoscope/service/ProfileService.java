package ru.rinatn.horoscope.service;

import java.util.Date;

import ru.rinatn.horoscope.model.Profile;

public class ProfileService
{
    public static Profile get()
    {
        Profile profile = null;

/*
        profile = new Profile();
        profile.setUsername("Константин Константинопольский");
        profile.setBirthdate(new Date());
        profile.setBirthhour(10);
        profile.setBirthminute(30);
        profile.setSex(Sex.male);
        profile.setRelationship(Relationship.single);
*/
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoaderActivity.this);
        //if (preferences)

        return profile;
    }

    public static Profile geti()
    {
        Profile profile = null;

        profile = new Profile();
        profile.setUsername("Константин Константинопольский");
        profile.setBirthdate(new Date());
        profile.setBirthhour(10);
        profile.setBirthminute(30);
        profile.setZodiac(2);
        profile.setSex(1);
        profile.setRelationship(3);

        return profile;
    }
}

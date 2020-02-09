package ru.rinatn.horoscope.ui.loader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.model.Profile;
import ru.rinatn.horoscope.service.ProfileService;
import ru.rinatn.horoscope.ui.forecast.ForecastActivity;
import ru.rinatn.horoscope.ui.profile.ProfileActivity;

public class LoaderActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        Profile profile = ProfileService.get();
        Intent intent;

        if (profile == null)
        {
            intent = new Intent(LoaderActivity.this, ProfileActivity.class);
        }
        else
        {
            intent = new Intent(LoaderActivity.this, ForecastActivity.class);

        }

        startActivity(intent);
    }
}

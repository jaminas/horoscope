package ru.rinatn.horoscope.ui.forecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.model.Forecast;
import ru.rinatn.horoscope.model.Profile;
import ru.rinatn.horoscope.service.ProfileService;
import ru.rinatn.horoscope.ui.profile.ProfileActivity;

public class ForecastActivity extends AppCompatActivity
{
    private RecyclerView flist;

    private RecyclerView.Adapter flistAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Toast toast = Toast.makeText(getApplicationContext(),"Menu: " + item.getItemId(), Toast.LENGTH_SHORT);
                        toast.show();

                        switch (item.getItemId()) {
                            case R.id.action_map:

                                break;
                            case R.id.action_dial:

                                break;
                            case R.id.action_mail:

                                break;
                        }
                        return false;
                    }
            }
        );

        Profile profile = ProfileService.get();

        if (profile == null)
        {
            Intent intent = new Intent(ForecastActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        else
        {
            flist = (RecyclerView) findViewById(R.id.flist);
            flist.setHasFixedSize(true);
            flist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


            final ForecastViewModel view_model = ViewModelProviders.of(this).get(ForecastViewModel.class);
            view_model.getData().observe(this, new Observer<List<Forecast>>()
            {
                @Override
                public void onChanged(@Nullable List<Forecast> forecasts)
                {
                    flistAdapter = new FlistAdapter(forecasts);
                    flist.setAdapter(flistAdapter);
                }
            });

        }

    }




}

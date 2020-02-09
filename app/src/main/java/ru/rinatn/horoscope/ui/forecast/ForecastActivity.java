package ru.rinatn.horoscope.ui.forecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//import butterknife.BindView;
import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.model.Forecast;
import ru.rinatn.horoscope.model.Profile;
import ru.rinatn.horoscope.service.ProfileService;
import ru.rinatn.horoscope.ui.loader.LoaderActivity;
import ru.rinatn.horoscope.ui.profile.ProfileActivity;

public class ForecastActivity extends AppCompatActivity
{
    //@BindView(R.id.title)
    TextView title;

    //@BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            final ForecastViewModel view_model = ViewModelProviders.of(this).get(ForecastViewModel.class);
            LiveData<Forecast> data = view_model.getData();
            data.observe(this, new Observer<Forecast>()
            {
                @Override
                public void onChanged(@Nullable Forecast fore)
                {
                    title.setText("Овен");
                    text.setText(fore.getText());
                }
            });

        }

    }


}

package ru.rinatn.horoscope.ui.forecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ru.rinatn.horoscope.R;

public class ForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_menu);

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

    }


}

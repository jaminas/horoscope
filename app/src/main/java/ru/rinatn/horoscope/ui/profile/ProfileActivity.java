package ru.rinatn.horoscope.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.ui.forecast.ForecastActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button save_btn = (Button) findViewById(R.id.save);
        save_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ProfileActivity.this, ForecastActivity.class);
                startActivity(intent);
            }
        });
    }
}

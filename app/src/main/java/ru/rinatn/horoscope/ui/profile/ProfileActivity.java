package ru.rinatn.horoscope.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.model.Profile;
import ru.rinatn.horoscope.service.ProfileService;
import ru.rinatn.horoscope.service.RelationshipService;
import ru.rinatn.horoscope.service.SexService;
import ru.rinatn.horoscope.service.ZodiacService;
import ru.rinatn.horoscope.ui.forecast.ForecastActivity;

public class ProfileActivity extends AppCompatActivity
{
    DatePickerDialog picker;
    EditText username;
    EditText birthdate;
    EditText birthhour;
    EditText birthminute;
    Spinner zodiac;
    Spinner sex;
    Spinner relationship;

    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = (EditText) findViewById(R.id.username);
        zodiac = (Spinner) findViewById(R.id.zodiac);
        sex = (Spinner) findViewById(R.id.sex);
        relationship = (Spinner) findViewById(R.id.relationship);
        birthdate = (EditText) findViewById(R.id.birthdate);
        birthhour = (EditText) findViewById(R.id.birthhour);
        birthminute = (EditText) findViewById(R.id.birthminute);

        //
        ArrayAdapter<String> zodiacAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, ZodiacService.getValues());
        zodiacAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zodiac.setAdapter(zodiacAdapter);

        //
        ArrayAdapter<String> sexAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, SexService.getValues());
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(sexAdapter);

        //
        ArrayAdapter<String> rlAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, RelationshipService.getValues());
        rlAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relationship.setAdapter(rlAdapter);

        //
        birthdate.setInputType(InputType.TYPE_NULL);
        birthdate.setOnClickListener(new View.OnClickListener()
        {
            @Override 
            public void onClick(View v)
            {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(ProfileActivity.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                        {
                            birthdate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        }
                }, year, month, day);
                picker.show();
            }
        });

        //
        Button save_btn = (Button) findViewById(R.id.save);
        save_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Profile profile = new Profile();
                profile.setUsername(username.getText().toString());
                try {
                    profile.setBirthdate(SDF.parse(birthdate.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    profile.setBirthhour(Integer.parseInt(birthhour.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    profile.setBirthminute(Integer.parseInt(birthminute.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(ProfileActivity.this, ForecastActivity.class);
                startActivity(intent);


            }
        });

        // помещаем данные пользователя в форму
        Profile profile = ProfileService.geti();
        if (profile != null)
        {
            if (profile.getUsername() != null) {
                username.setText(profile.getUsername());
            }
            if (profile.getBirthdate() != null) {
                birthdate.setText(SDF.format(profile.getBirthdate()));
            }
            if (profile.getBirthhour() != null) {
                birthhour.setText(profile.getBirthhour().toString());
            }
            if (profile.getBirthminute() != null) {
                birthminute.setText(profile.getBirthminute().toString());
            }
            if (profile.getZodiac() != null) {
                zodiac.setSelection(profile.getZodiac() - 1, true);
            }

            if (profile.getSex() != null) {
                sex.setSelection(profile.getSex() - 1, true);
            }
            if (profile.getRelationship() != null) {
                relationship.setSelection(profile.getRelationship() - 1, true);
            }
        }

    }
}

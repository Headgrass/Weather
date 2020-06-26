package ru.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.weather.databinding.ActivityMainBinding;


public class Settings extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        btnGoBack();



    }
    private void btnGoBack() {
       final EditText editCity = findViewById(R.id.editCity);
        Button back_to_main = findViewById(R.id.backToMain);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        saveInstanceState.getBoolean("Humidity");
        saveInstanceState.getBoolean("Pressure");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        CheckBox humidity = findViewById(R.id.checkboxHumidity);
        saveInstanceState.putBoolean("Humidity", humidity.isChecked());
        CheckBox pressure = findViewById(R.id.checkboxPressure);
        saveInstanceState.putBoolean("Pressure", pressure.isChecked());
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }
}

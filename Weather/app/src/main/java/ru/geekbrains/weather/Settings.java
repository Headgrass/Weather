package ru.geekbrains.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        changeCityMethod();
        btnGoBack();
    }

    private void changeCityMethod() {
        ((EditText) findViewById(R.id.editCity)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                city = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void btnGoBack() {
        Button back_to_main = findViewById(R.id.backToMain);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(Constants.ARG_1, city);
                setResult(Activity.RESULT_OK, intent);
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

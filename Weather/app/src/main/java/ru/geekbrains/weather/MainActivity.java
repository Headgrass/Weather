package ru.geekbrains.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.geekbrains.weather.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        btnGo2Activity();
    }

    private void btnGo2Activity() {
        Button btn = findViewById(R.id.btn_set);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                intent.putExtra("City", "Run Settings Activity");
                startActivityForResult(intent, Constants.REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            TextView currCity = findViewById(R.id.current_City);
            currCity.setText(data.getStringExtra(Constants.ARG_1));
        }
    }
}

package ru.geekbrains.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import ru.geekbrains.weather.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        List<WeatherData> list = Arrays.asList(
                new WeatherData("ПН", R.drawable.cloudy_rain_small, 16, "облачно с дождем"),
                new WeatherData("ВТ", R.drawable.cloudy_sun_small, 19, "тучки и солнечно"),
                new WeatherData("СР", R.drawable.sun_small, 21, "очень солнечно"),
                new WeatherData("ЧТ", R.drawable.sun_small, 22, "очень солнечно"),
                new WeatherData("ПТ", R.drawable.cloudy_sun_small, 18, "тучки и солнечно"),
                new WeatherData("СБ", R.drawable.cloudy_rain_small, 20, "дождливо"),
                new WeatherData("ВС", R.drawable.sun_small, 22, "солнечно")
        );

        SimpleAdapter adapter = new SimpleAdapter();
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycleview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        //adapter.setData(list);

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

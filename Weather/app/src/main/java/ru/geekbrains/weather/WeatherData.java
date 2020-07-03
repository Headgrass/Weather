package ru.geekbrains.weather;

import android.graphics.drawable.Drawable;

public class WeatherData {
    private String day;
    private int imageResourceId;
    private int temp;
    private String description;

    public static final WeatherData[] fewdays = {
            new WeatherData("ПН", R.drawable.cloudy_rain_small, 16, "облачно с дождем"),
            new WeatherData("ВТ", R.drawable.cloudy_sun_small, 19, "тучки и солнечно"),
            new WeatherData("СР", R.drawable.sun_small, 21, "очень солнечно"),
            new WeatherData("ЧТ", R.drawable.sun_small, 22, "очень солнечно"),
            new WeatherData("ПТ", R.drawable.cloudy_sun_small, 18, "тучки и солнечно"),
            new WeatherData("СБ", R.drawable.cloudy_rain_small, 20, "дождливо"),
            new WeatherData("ВС", R.drawable.sun_small, 22, "солнечно"),
    };

    public WeatherData(String day, int imageResourceId, int temp, String description) {
        this.day = day;
        this.imageResourceId = imageResourceId;
        this.temp = temp;
        this.description = description;
    }
    public String getDay(){
        return day;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }
    public int getTemp(){
        return temp;
    }
    public String getDescription(){
        return description;
    }
}

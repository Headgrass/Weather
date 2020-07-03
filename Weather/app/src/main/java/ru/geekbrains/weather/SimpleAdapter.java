package ru.geekbrains.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private ArrayList<WeatherData> dataList = new ArrayList<>();

    public void setData(List<WeatherData> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.bind(dataList.get(position));

}

    @Override
    public int getItemCount() {
        return dataList.size();
    }

static class SimpleViewHolder extends RecyclerView.ViewHolder {
    private TextView fewday1;
    private ImageView fewImg1;
    private TextView fewTemp1;
    private TextView description1;

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);

        fewday1 = itemView.findViewById(R.id.fewDay);
        fewImg1 = itemView.findViewById(R.id.fewImg);
        fewTemp1 = itemView.findViewById(R.id.fewTemp);
        description1 = itemView.findViewById(R.id.description);
    }

    public void bind(WeatherData item) {
        fewday1.setText(String.valueOf(item.getDay()));
        fewImg1.setImageResource(item.getImageResourceId());
        fewTemp1.setText(String.valueOf(item.getTemp()));
        description1.setText(String.valueOf(item.getDescription()));
    }
}
}

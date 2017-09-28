package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Daniel on 13.02.2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.forecast_list_item, parent, false);
        ForecastAdapterViewHolder forecastAdapterViewHolder = new ForecastAdapterViewHolder(view);

        return forecastAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weather = mWeatherData[position];
        holder.mWeatherTextView.setText(weather);
        // More beautiful would be to add a public method "bind(int position)" to the
        // ForecastAdapterViewHolder, and call that method instead of accessing its attribute
        // mWeatherTextView directly.
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null)
            return 0;
        return mWeatherData.length;
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

}

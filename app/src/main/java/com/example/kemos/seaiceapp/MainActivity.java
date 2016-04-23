package com.example.kemos.seaiceapp;


import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

import com.example.kemos.seaiceapp.Model.FetchWeatherTask;
import com.example.kemos.seaiceapp.Model.WeatherItem;
import com.example.kemos.seaiceapp.Model.WeatherOperations;

import java.sql.SQLException;

public class MainActivity extends Activity {

    LocationManager locationManager;
    MyLocListener locListener;
    WeatherOperations weatherOperations ;
    FetchWeatherTask fetchWeatherTask;
    WeatherItem weatherItemToday;
    double longitude  ;
    double latitude ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherOperations = new WeatherOperations(this);
        try {
            weatherOperations.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      //  for ( int i = 0 ; i < Data.lons.length ; i ++ )
      //      weatherOperations.addWeather(Data.lons[i], Data.lats[i], Data.temp[i], 2  , Data.thickness[i], "2016-4-22");

        double lon = -104.975657 ;
        double lat = 82.184518 ;

        WeatherItem weatherItemPast  = weatherOperations.getWeather(lon,lat);
/*
        Log.d("temp ----", weatherItemPast.getTemp() + "");
        Log.d("wind --- ", weatherItemPast.getWind() + "");
        Log.d("date --- ", weatherItemPast.getDate() + "");
        Log.d("lon --- ", weatherItemPast.getLongitude() + "");

        weatherOperations.updateWeather(lon,lat,
                weatherItemPast.getTemp()+1,
               weatherItemPast.getWind()+1,
                weatherItemPast.getThickness()+1,
                "2008");

        weatherItemPast  = weatherOperations.getWeather(lon,lat);

        Log.d("temp uu ----", weatherItemPast.getTemp() + "");
        Log.d("wind uu--- ", weatherItemPast.getWind() + "");
        Log.d("date uu--- ", weatherItemPast.getDate() + "");
        Log.d("lon uu--- ", weatherItemPast.getLongitude() + "");

*/
    //    WeatherItem weatherItemPast = weatherOperations.getWeather(lon,lat);
           fetchWeatherTask = new FetchWeatherTask(this , lon, lat  );
           fetchWeatherTask.execute("");
 //       delay();
  //  form

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
      /*
        locListener = new MyLocListener();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locListener);
*/
//        Log.e("Latitude",""+location.getLatitude());
  //      Log.e("Longitude",""+location.getLongitude());


    }

    public void delay() {

        final Handler h = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if ( fetchWeatherTask.getWeatherData() != null)
                    weatherItemToday = fetchWeatherTask.getWeatherData();
                else
                    h.postDelayed(this, 0);
            }
        };
        h.postDelayed(runnable, 1000);

    }

}

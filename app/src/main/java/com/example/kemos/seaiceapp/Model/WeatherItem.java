package com.example.kemos.seaiceapp.Model;

public class WeatherItem  {
    private float longitude ;
    private float latitude ;
    private float temp ;
    private float thickness ;

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    private float wind ;
    private String date;


    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

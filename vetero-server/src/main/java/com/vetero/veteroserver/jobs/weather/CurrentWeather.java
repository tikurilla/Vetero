package com.vetero.veteroserver.jobs.weather;

import org.bson.types.ObjectId;

import java.util.Date;

public class CurrentWeather {
    private ObjectId locationId;
    private Date currentDate;
    private Integer temp;
    private Integer feelsLike;
    private String condition;
    private Integer windSpeed;
    private Float windGust;
    private String windDir;
    private Integer pressureMm;
    private Integer pressurePa;
    private Integer humidity;
    private String daytime;
    private Boolean polar;
    private String season;

    public ObjectId getLocationId() {
        return locationId;
    }

    public void setLocationId(ObjectId locationId) {
        this.locationId = locationId;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getWindGust() {
        return windGust;
    }

    public void setWindGust(Float windGust) {
        this.windGust = windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Integer getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(Integer pressureMm) {
        this.pressureMm = pressureMm;
    }

    public Integer getPressurePa() {
        return pressurePa;
    }

    public void setPressurePa(Integer pressurePa) {
        this.pressurePa = pressurePa;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Boolean getPolar() {
        return polar;
    }

    public void setPolar(Boolean polar) {
        this.polar = polar;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}

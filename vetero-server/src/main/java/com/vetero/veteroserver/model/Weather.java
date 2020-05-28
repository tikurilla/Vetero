package com.vetero.veteroserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Weather implements Serializable {
    private Integer temp;

    @JsonProperty(value = "feels_like")
    private Integer feelsLike;
    private String icon;
    private String condition;

    @JsonProperty(value = "wind_speed")
    private Integer windSpeed;

    @JsonProperty(value = "wind_gust")
    private Float windGust;

    @JsonProperty(value = "wind_dir")
    private String windDir;

    @JsonProperty(value = "pressure_mm")
    private Integer pressureMm;

    @JsonProperty(value = "pressure_pa")
    private Integer pressurePa;

    private Integer humidity;
    private String daytime;
    private Boolean polar;
    private String season;

    @JsonProperty(value = "obs_time")
    private Date obsTime;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Date getObsTime() {
        return obsTime;
    }

    public void setObsTime(Date obsTime) {
        this.obsTime = obsTime;
    }
}

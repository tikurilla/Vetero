package com.vetero.veteroserver.model;

import java.io.Serializable;
import java.time.ZoneOffset;

public class Location implements Serializable {
    private String city;
    private String cityRu;
    private String country;
    private String countryRu;
    private Coordinate coordinate;
    private ZoneOffset zoneOffset;
    private Boolean enable;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityRu() {
        return cityRu;
    }

    public void setCityRu(String cityRu) {
        this.cityRu = cityRu;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryRu() {
        return countryRu;
    }

    public void setCountryRu(String countryRu) {
        this.countryRu = countryRu;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}

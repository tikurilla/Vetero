package com.vetero.veteroserver.services.repository;

import com.vetero.veteroserver.jobs.weather.CurrentWeather;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CurrentWeatherRepository extends PagingAndSortingRepository<CurrentWeather, String> {
    List<CurrentWeather> findCurrentWeathersByLocationId(ObjectId locationId);
}

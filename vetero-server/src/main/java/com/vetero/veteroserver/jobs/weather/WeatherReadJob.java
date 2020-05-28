package com.vetero.veteroserver.jobs.weather;

import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.model.Weather;
import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.services.LocationCache;
import com.vetero.veteroserver.services.repository.CurrentWeatherRepository;
import com.vetero.veteroserver.services.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WeatherReadJob {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private LocationCache locationCache;

    @Autowired
    private Logger logger;

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @Scheduled(cron = "${weather.read.job.cron}")
    public void readWeather() {
        // todo rewrite this
        Location location =  locationCache.getLocation("Moscow");
        Weather weather = weatherService.getCurrentWeather(location.getCoordinate());

        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setLocationId(location.getId());
        currentWeather.setCurrentDate(new Date());
        currentWeather.setLocationId(location.getId());
        currentWeather.setTemp(weather.getTemp());
        currentWeather.setFeelsLike(weather.getFeelsLike());
        currentWeather.setCondition(weather.getCondition());
        currentWeather.setWindSpeed(weather.getWindSpeed());
        currentWeather.setWindGust(weather.getWindGust());
        currentWeather.setWindDir(weather.getWindDir());
        currentWeather.setPressureMm(weather.getPressureMm());
        currentWeather.setPressurePa(weather.getPressurePa());
        currentWeather.setHumidity(weather.getHumidity());
        currentWeather.setDaytime(weather.getDaytime());
        currentWeather.setPolar(weather.getPolar());
        currentWeather.setSeason(weather.getSeason());

        currentWeatherRepository.save(currentWeather);

        logger.info(weather.getTemp().toString());
    }
}

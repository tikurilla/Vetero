package com.vetero.veteroserver.jobs;

import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.model.CurrentWeather;
import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.services.LocationCache;
import com.vetero.veteroserver.services.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherReadJob {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private LocationCache locationCache;

    @Autowired
    private Logger logger;

    @Scheduled(cron = "${weather.read.job.cron}")
    public void readWeather() {
        // todo rewrite this
        Location location =  locationCache.getLocation("Moscow");
        CurrentWeather currentWeather = weatherService.getCurrentWeather(location.getCoordinate());
        logger.info(currentWeather.getTemp().toString());
    }
}

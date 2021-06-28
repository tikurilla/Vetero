package com.vetero.veteroserver.rest.weather;

import com.vetero.veteroserver.jobs.weather.CurrentWeather;
import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.rest.exceptions.DataNotFoundException;
import com.vetero.veteroserver.rest.exceptions.RestException;
import com.vetero.veteroserver.services.LocationCache;
import com.vetero.veteroserver.services.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/weather")
public class WeatherApi {
    @Autowired
    private LocationCache locationCache;

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @GetMapping("/{city}")
    @ResponseBody
    public List<CurrentWeather> getLocation(@PathVariable("city") String city) throws RestException {
        // List<CurrentWeather> todo here we need real location name not locationId
        Location location = locationCache.getLocation(city);

        if (location == null) {
            throw new DataNotFoundException(String.format("Can't find weather with city name = %s", city));
        }

        return currentWeatherRepository.findCurrentWeathersByLocationId(location.getId());
    }
}

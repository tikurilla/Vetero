package com.vetero.veteroserver.services;

import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.services.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LocationCache {
    private Map<String, Location> cache = new HashMap<>();

    @Autowired
    private LocationRepository locationRepository;

    @PostConstruct
    public void init() {
        Stream<Location> locationStream = locationRepository.findAllBy();

        cache.putAll(locationStream.collect(Collectors.toMap(Location::getCity, location -> location)));
    }

    public Location getLocation(String city) {
        return cache.get(city);
    }

    public boolean isExist(String city) {
        return cache.containsKey(city);
    }

    public void update(Location location) {
        String city = location.getCity();
        cache.put(city, location);
    }
}

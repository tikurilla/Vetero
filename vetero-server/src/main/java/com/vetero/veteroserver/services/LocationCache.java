package com.vetero.veteroserver.services;

import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.services.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<Location> getAll() {
        List<Location> result = new ArrayList<>();

        for(Map.Entry<String, Location> entry : cache.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public List<Location> getEnabledLocations() {
        List<Location> result = new ArrayList<>();

        for(Map.Entry<String, Location> entry : cache.entrySet()) {
            Location location = entry.getValue();
            if (location.getEnable()) {
                result.add(location);
            }
        }

        return result;
    }

    public boolean isExist(String city) {
        return cache.containsKey(city);
    }

    public void update(Location location) {
        String city = location.getCity();
        cache.put(city, location);
    }
}

package com.vetero.veteroserver.rest.location;

import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.rest.exceptions.ConflictException;
import com.vetero.veteroserver.rest.exceptions.DataNotFoundException;
import com.vetero.veteroserver.rest.exceptions.IncorrectParameterException;
import com.vetero.veteroserver.rest.exceptions.RestException;
import com.vetero.veteroserver.rest.location.model.LocationInfo;
import com.vetero.veteroserver.services.LocationCache;
import com.vetero.veteroserver.services.repository.LocationRepository;
import com.vetero.veteroserver.utils.ArgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/location")
public class LocationApi {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ArgUtils argUtils;

    @Autowired
    private LocationCache locationCache;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.OK)
    public void addLocation(@RequestBody Location location) throws RestException {
        String cityNameEn = location.getCity();
        if (argUtils.isBlank(cityNameEn)) {
            throw new IncorrectParameterException("Location doesn't contain city name");
        }

        String countryNameEn = location.getCountry();
        if (argUtils.isBlank(countryNameEn)) {
            throw new IncorrectParameterException("Location doesn't contain country name");
        }

        Location locationPersist = locationRepository.findLocationByCityAndCountry(cityNameEn, countryNameEn);
        if (locationPersist != null) {
            throw new ConflictException("Specified location already exists");
        }

        locationRepository.save(location);
        locationCache.update(location);
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Boolean> deleteLocation(@RequestBody LocationInfo locationInfo) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", false);

        Long result =  locationRepository.deleteLocationByCityAndCountry(locationInfo.getCity(), locationInfo.getCountry());

        if (result > 0) {
            locationCache.delete(locationInfo.getCity());
            response.put("deleted", true);
        }

        return response;
    }

    @GetMapping("/{city}")
    @ResponseBody
    public Location getLocation(@PathVariable("city") String city) throws RestException {
        Location location = locationCache.getLocation(city);

        if (location == null) {
            throw new DataNotFoundException(String.format("Can't find location with city name '%s'", city));
        }

        return location;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Location> getAllLocations() {
        return locationCache.getAll();
    }
}

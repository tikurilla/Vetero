package com.vetero.veteroserver.rest.location;

import com.vetero.veteroserver.model.Location;
import com.vetero.veteroserver.rest.exceptions.DataNotFoundException;
import com.vetero.veteroserver.rest.exceptions.IncorrectParameterException;
import com.vetero.veteroserver.rest.exceptions.RestException;
import com.vetero.veteroserver.rest.location.model.LocationInfo;
import com.vetero.veteroserver.services.LocationCache;
import com.vetero.veteroserver.services.repository.LocationRepository;
import com.vetero.veteroserver.utils.ArgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/location")
public class LocationAPI {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ArgUtils argUtils;

    @Autowired
    private LocationCache locationCache;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addLocation(@RequestBody Location location) throws RestException {
        String cityNameEn = location.getCity();
        if (argUtils.isBlank(cityNameEn)) {
            return new IncorrectParameterException("Location doesn't contain city name"); // todo in this case exception prints whole stacktrace, it's huge!
        }

        String countryNameEn = location.getCountry();
        if (argUtils.isBlank(countryNameEn)) {
            return new IncorrectParameterException("Location doesn't contain country name");
        }

        locationRepository.save(location);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> deleteLocation(@RequestBody LocationInfo locationInfo) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", false);

        Long result =  locationRepository.deleteLocationByCityAndCountry(locationInfo.getCity(), locationInfo.getCountry());

        if (result > 0) {
            response.put("deleted", true);
        }

        return response;
    }

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    @ResponseBody
    public Location getLocation(@PathVariable("city") String city) throws RestException {
        Location location = locationCache.getLocation(city);

        if (location == null) {
            throw new DataNotFoundException(String.format("Can't find location with city name = ", city));
        }

        return location;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> getAllLocations() throws RestException {
        return locationCache.getAll();
    }
}

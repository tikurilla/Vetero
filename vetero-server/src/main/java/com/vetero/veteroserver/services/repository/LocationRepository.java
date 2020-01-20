package com.vetero.veteroserver.services.repository;

import com.vetero.veteroserver.model.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.stream.Stream;

public interface LocationRepository extends PagingAndSortingRepository<Location, String> {
    Long deleteLocationByCityAndCountry(String city, String country);

    Stream<Location> findAllBy();
}

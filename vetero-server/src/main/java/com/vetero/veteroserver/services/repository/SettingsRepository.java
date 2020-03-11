package com.vetero.veteroserver.services.repository;

import com.vetero.veteroserver.model.Setting;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.stream.Stream;

public interface SettingsRepository extends PagingAndSortingRepository<Setting, String> {
    Stream<Setting> findAllBy();
}

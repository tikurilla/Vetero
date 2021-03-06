package com.vetero.veteroserver.services;

import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.model.Setting;
import com.vetero.veteroserver.services.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SettingsService {
    private Map<String, Setting> cache = new HashMap<>();

    @Autowired
    private SettingsRepository settingsRepository;
    
    @Autowired
    private Logger logger;

    @PostConstruct
    public void init() {
        Stream<Setting> settingsStream = settingsRepository.findAllBy();

        cache.putAll(settingsStream.collect(Collectors.toMap(Setting::getCode, setting -> setting)));
    }

    public Setting getSetting(String code) {
        return cache.get(code);
    }

    public String getString(String code) {
        Setting setting = getSetting(code);
        if (setting != null) {
            return setting.getValue();
        }

        throw new IllegalStateException("Property " + code + " not found!");
    }
    
    public int getInt(String code) {
        try {
            return Integer.valueOf(getString(code));
        } catch (NumberFormatException ex) {
            logger.warn("Can not convert setting to integer", ex);
        } finally {
            return 0;
        }
    }

    public boolean isExist(String code) {
        return cache.containsKey(code);
    }

    public void update(Setting setting) {
        cache.put(setting.getCode(), setting);
    }
}

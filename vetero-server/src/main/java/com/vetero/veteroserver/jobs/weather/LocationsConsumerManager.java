package com.vetero.veteroserver.jobs.weather;

import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LocationsConsumerManager {
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private SettingsService settings;

    @Autowired
    private Logger logger;

    @Autowired
    private LocationsQueue queue;

    @PostConstruct
    public void init() {
        int consumersCount = settings.getInt("location.consumer.task.count");
        for (int i = 0; i < consumersCount; i++) {
            if (executor != null) {
                executor.execute(new LocationsConsumer(this));
                logger.info("### ADDED LOCATIONS CONSUMER №" + i);
            }
        }
    }

    @PreDestroy
    public void destroy() {
        executor.shutdown();
    }

    public Logger getLogger() {
        return logger;
    }

    public LocationsQueue getQueue() {
        return queue;
    }
}

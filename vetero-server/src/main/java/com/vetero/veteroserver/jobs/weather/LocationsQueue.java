package com.vetero.veteroserver.jobs.weather;

import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@ApplicationScope
public class LocationsQueue {
    private LinkedBlockingQueue<Location> queue = new LinkedBlockingQueue<>();

    @Autowired
    private Logger logger;

    private boolean started;

    @PostConstruct // todo check if Postconstruct work well
    public void init() {
        started = true;
    }

    @PreDestroy
    public void destroy() {
        started = false;
    }

    public Location next() throws InterruptedException {
        return queue.poll(100, TimeUnit.MILLISECONDS);
    }

    public void push(final Location location) {
        boolean offer = queue.offer(location);
        if(!offer) {
            logger.warn("Location has not been added to queue!");
        }
    }

    public void push(final List<Location> locationList) {
        for(Location location : locationList) {
            push(location);
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isStarted() {
        return started;
    }
}

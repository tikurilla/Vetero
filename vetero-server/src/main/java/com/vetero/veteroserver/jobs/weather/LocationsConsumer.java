package com.vetero.veteroserver.jobs.weather;

import com.vetero.veteroserver.model.Location;

public class LocationsConsumer implements Runnable {
    private LocationsConsumerManager manager;

    public LocationsConsumer(LocationsConsumerManager locationsSaverManager) {
        this.manager = locationsSaverManager;
        manager.getLogger().info("Location saver task launched");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("LocationConsumerThread");

        while (manager.getQueue().isStarted()) {
            try {
                Location location = manager.getQueue().next();

                if (location == null) {
                    continue;
                }

//                manager.getCommandsCreateService().addCommand(rawCommand);
            } catch (InterruptedException e) {
                manager.getLogger().error("CommandsSaverThread interrupted!!! " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                manager.getLogger().error("Failed to save command to DB", e);
            }
        }
    }
}

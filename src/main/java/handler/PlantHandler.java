package handler;

import config.Configuration;
import domain.plant.Plant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class PlantHandler {

    public static BlockingQueue<Plant> queue = new ArrayBlockingQueue<>(Configuration.getInstance().getPlantQuantity() / 2);

    ThreadGroup plantHandlerGroup = new ThreadGroup("plantHandler");
    Thread consumerThread = new Thread(plantHandlerGroup, new PlantConsumer());
    Thread producerThread = new Thread(plantHandlerGroup, new PlantProducer());

    public void startHandler() {
        consumerThread.start();
        producerThread.start();
    }

    public void stopHandler() {
        consumerThread.interrupt();
        producerThread.interrupt();
    }

    private class PlantConsumer implements Runnable {

        @Override
        public void run() {

        }
    }

    private class PlantProducer implements Runnable {

        @Override
        public void run() {

        }
    }

}

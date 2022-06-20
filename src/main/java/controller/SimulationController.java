package controller;

import domain.area.Area;
import domain.area.Cell;
import domain.plant.Plant;
import utils.Constants;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class SimulationController {

    ExecutorService executor = Executors.newFixedThreadPool(3);

    public static volatile boolean simulationEnd = false;

    public void start() {
        System.out.println("Start the app");
        executor.submit(new AreaController());
        executor.submit(new AnimalController());
        executor.submit(new PlantController());
        executor.shutdown();
    }

    public void stop() {
        System.out.println("Stop the app");
        simulationEnd = true;
        executor.shutdownNow();
    }
}
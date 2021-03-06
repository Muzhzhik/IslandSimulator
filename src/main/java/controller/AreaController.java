package controller;

import domain.animal.Animal;
import domain.area.Area;
import domain.area.Cell;
import domain.plant.Plant;

import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class AreaController implements Runnable {

    Area area = Area.getInstance();

    @Override
    public void run() {
        System.out.println("Area controller works");
        while (!SimulationController.simulationEnd) {
            drawArea();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    private void drawArea() {
        System.out.println("--------------------------------");
        for (Cell[] cell : area.getCells()) {
            for (Cell value : cell) {
//                System.out.print(value.getId() +  " ");
                if (!value.getAnimals().isEmpty()) {
                    drawAnimals(value);
                } else {
                    drawPlants(value);
                }
            }
            System.out.println("");
        }
    }

    private void drawPlants(Cell cell) {
        List<Plant> plants = cell.getPlants();
        if (plants != null && !plants.isEmpty()) {
            Plant plant = plants.stream().findAny().get();
            if (plant.isAlive()) {
                System.out.print(plant.getName() + " ");
            } else {
                System.out.print("\uD83D\uDC63 ");
            }
        } else {
            System.out.print("\uD83D\uDC63" + " ");
        }
    }

    private void drawAnimals(Cell cell) {
        List<Animal> animals = cell.getAnimals();
        if (animals != null && !animals.isEmpty()) {
            Animal animal = animals.get(0);
            if (animal != null) {
                System.out.print(animal.getName() + " ");
            }
        } else {
            System.out.print("\uD83D\uDC63" + " ");
        }
    }
}

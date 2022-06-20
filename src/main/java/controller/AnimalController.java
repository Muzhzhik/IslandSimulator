package controller;

import domain.animal.Animal;
import domain.area.Area;
import domain.area.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class AnimalController implements Runnable {

    Area area = Area.getInstance();

    @Override
    public void run() {
        while (!SimulationController.simulationEnd) {
            System.out.println("Animal controller works");
            sleep();
            for (Cell[] cells : area.getCells()) {
                for (Cell cell : cells) {
                    List<Animal> animals = cell.getAnimals();
                  //  System.out.println(animals.size());
                    for (Animal animal : animals) {
                        animal.eat();
                        animal.reproduce();
                        animal.relocate();
                        break;
                    }
                }
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}

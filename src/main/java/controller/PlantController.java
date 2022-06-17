package controller;

import config.Configuration;
import domain.area.Area;
import domain.area.Cell;
import domain.plant.Plant;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class PlantController implements Runnable {

    Area area = Area.getInstance();

    @Override
    public void run() {
        System.out.println("Plant controller works");
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                // Do nothing
            }
            checkAllPlants();
        }
    }

    private void checkAllPlants() {
        System.out.println("Check all plants");
        for (Cell[] cells : area.getCells()) {
            for (Cell cell : cells) {
                checkCellPlants(cell);
            }
        }
    }

    private void checkCellPlants(Cell currentCell) {
        List<Plant> plants = currentCell.getPlants();
        if (plants != null && !plants.isEmpty()) {
          //  Collections.shuffle(plants);
            for(Plant plant : plants) {
                tryToReviveInOtherCell(plant, currentCell);
                plant.killOrRevive();
            }
        }
    }

    private void tryToReviveInOtherCell(Plant plant, Cell currentCell) {
        final int chance = 10; //TODO Move to configuration.yaml
        int random = ThreadLocalRandom.current().nextInt(1000);
    //    System.out.println("Random: " + random);
        if (random < chance) {
            movePlantToAnotherCell(plant, currentCell);
        }
    }

    private void movePlantToAnotherCell(Plant plant, Cell currentCell) {
        System.out.println("Plant is relocate");
        final int maxCellId = Configuration.getInstance().getAreaHeight() * Configuration.getInstance().getAreaHeight();
        int randomCellId = ThreadLocalRandom.current().nextInt(maxCellId);
        //remove obj and add to other cell
        if (randomCellId != currentCell.getId()) {
            Cell cell = area.getCellById(randomCellId);
            if (cell.addPlant(plant)) {
                System.out.println("Plant added");
//                currentCell.getPlants().remove(plant);
            }
        }
    }
}

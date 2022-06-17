package domain.area;

import config.Configuration;
import domain.plant.Plant;
import objectgeneration.PlantGenerator;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Area {

    private static Area area;
    Configuration configuration = Configuration.getInstance();
    private final Cell[][] cells = new Cell[configuration.getAreaHeight()][configuration.getAreaWidth()];

    private Area() {};

    public static Area getInstance() {
        if (area == null) {
            area = new Area();
            area.createArea();
        }
        return area;
    }

    private void createArea() {
        initCells();
        addAnimals();
        addPlants();
    }

    private void initCells() {
        int counter = 1;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(counter++);
            }
        }
    }

    private void addAnimals() {
        System.out.println("Adding animals");
     //   Queue<Animal> animals = new LinkedList<>(new AnimalGenerator().generate());
    }

    private void addPlants() {
        System.out.println("Adding plants");
        Queue<Plant> plants = new LinkedList<>(new PlantGenerator().generate());
        boolean stop = false;
        while (!plants.isEmpty()) {
            if (stop) {
                break;
            }
            for (Cell[] cell : cells) {
                if (stop) {
                    break;
                }
                for (Cell value : cell) {
                    if (plants.isEmpty()) {
                        stop = true;
                        break;
                    }
                    addRandomPlantsQuantity(value, plants);
                }
            }
        }
    }

    private void addRandomPlantsQuantity(Cell cell, Queue<Plant> plants) {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (plants.size() < 3) {
            randomInt = plants.size();
        }

        for (int i = 0; i < randomInt; i++) {
            if (plants.isEmpty()) {
                break;
            }
            Plant plant = plants.peek();
            if (cell.addPlant(plant)){
                plants.remove();
            } else {
                break;
            }
        }
    }

    public Cell getCellById(int cellId) {
        Cell result = null;
        int areaWidth = Configuration.getInstance().getAreaWidth();
        int startRow = (int) Math.floor(cellId / areaWidth);
        System.out.println("Find ID: " + cellId);
        System.out.println("StartRow: " + startRow);
        synchronized (cells) {
            for (int i = 0; i < areaWidth; i++) {
                Cell element = cells[startRow][i];
                if (cellId == element.getId()) {
                    System.out.println("Element found!");
                    result = element;
                    break;
                }
            }
        }
        return result;
    }
}

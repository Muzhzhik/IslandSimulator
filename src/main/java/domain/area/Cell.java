package domain.area;

import config.Configuration;
import controller.SimulationController;
import domain.animal.Animal;
import domain.plant.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
@Setter
public class Cell {

    private int id;
    private List<Animal> animals = new CopyOnWriteArrayList<>();
    private List<Plant> plants = new CopyOnWriteArrayList<>();

    public Cell(int id) {
        this.id = id;
    }

    public boolean addPlant(Plant plant) {
        boolean result = false;
        if (plants.size() < plant.getMaxQuantityForCell()) {
            plants.add(plant);
            result = true;
        }
        return result;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}

package domain.area;

import domain.animal.Animal;
import domain.plant.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
    private Map<String, Integer> objectCounts = new ConcurrentHashMap();

    public Cell(int id) {
        this.id = id;
    }

    public boolean addPlant(Plant plant) {
        return addObject(plant);
    }

    public boolean addAnimal(Animal animal) {
        return addObject(animal);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
        // TODO decrement ili udalit nax
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        // TODO decrement ili udalit nax
    }

    private boolean addObject(Object o) {
        boolean result = false;
        var count = getCounterValue(o.getClass().getSimpleName());
        int maxQuantityForCell = 0;
        if (o instanceof Plant) {
            maxQuantityForCell = ((Plant) o).getMaxQuantityForCell();
        } else if (o instanceof Animal) {
            maxQuantityForCell = ((Animal) o).getMaxQuantityForCell();
        }
        if (count < maxQuantityForCell) {
            if(o instanceof Plant) {
                plants.add((Plant) o);
            } else if (o instanceof Animal) {
                animals.add((Animal) o);
            }
            incrementCounter(o.getClass().getSimpleName());
            result = true;
        }
        return result;
    }

    private void incrementCounter(String className) {
        var value = objectCounts.get(className);
        if (value == null) {
            objectCounts.put(className, 1);
        } else {
            objectCounts.put(className, ++value);
        }
    }

    private void decrementCounter(String className) {
        //TODO
    }

    private int getCounterValue(String className) {
        var value = objectCounts.get(className);
        if (value == null) {
            objectCounts.put(className, 0);
            value = 0;
        }
        return value;
    }
}

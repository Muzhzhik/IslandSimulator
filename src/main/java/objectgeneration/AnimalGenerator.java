package objectgeneration;

import config.AnimalConfiguration;
import config.Configuration;
import domain.animal.Animal;
import domain.animal.AnimalFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class AnimalGenerator {

    Configuration configuration = Configuration.getInstance();

    public List<Animal> generate() {
        List<Animal> animalList = new ArrayList<>();
        for (AnimalConfiguration animalConfiguration : configuration.getAnimalConfigurations()) {
            for (int i = 0; i < animalConfiguration.getStartQuantity(); i++) {
                animalList.add(new AnimalFactory().createByName(animalConfiguration.getClassName()));
            }
        }
        Collections.shuffle(animalList);
        return animalList;
    }
}

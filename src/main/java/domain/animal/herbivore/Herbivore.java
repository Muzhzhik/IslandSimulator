package domain.animal.herbivore;

import config.AnimalConfiguration;
import domain.animal.Animal;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public abstract class Herbivore extends Animal {
    protected Herbivore(AnimalConfiguration configuration) {
        super(configuration);
    }
}

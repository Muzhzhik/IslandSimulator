package domain.animal.predator;

import config.AnimalConfiguration;
import domain.animal.Animal;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public abstract class Predator extends Animal {
    protected Predator(AnimalConfiguration configuration) {
        super(configuration);
    }
}

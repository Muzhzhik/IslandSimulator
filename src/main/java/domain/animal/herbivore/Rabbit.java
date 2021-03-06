package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Rabbit extends Herbivore {
    public Rabbit(AnimalConfiguration configuration) {
        super(configuration);
    }
}

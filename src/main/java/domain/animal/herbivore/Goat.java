package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Goat extends Herbivore {
    public Goat(AnimalConfiguration configuration) {
        super(configuration);
    }
}

package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Horse extends Herbivore {
    public Horse(AnimalConfiguration configuration) {
        super(configuration);
    }
}

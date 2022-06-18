package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Sheep extends Herbivore {
    public Sheep(AnimalConfiguration configuration) {
        super(configuration);
    }
}

package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Buffalo extends Herbivore {
    public Buffalo(AnimalConfiguration configuration) {
        super(configuration);
    }
}

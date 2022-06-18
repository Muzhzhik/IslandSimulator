package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Deer extends Herbivore {
    public Deer(AnimalConfiguration configuration) {
        super(configuration);
    }
}

package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Boar extends Herbivore {
    public Boar(AnimalConfiguration configuration) {
        super(configuration);
    }
}

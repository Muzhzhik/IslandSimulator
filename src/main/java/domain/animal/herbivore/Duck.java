package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Duck extends Herbivore {
    public Duck(AnimalConfiguration configuration) {
        super(configuration);
    }
}

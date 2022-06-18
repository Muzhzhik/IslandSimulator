package domain.animal.herbivore;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Mouse extends Herbivore {
    public Mouse(AnimalConfiguration configuration) {
        super(configuration);
    }
}

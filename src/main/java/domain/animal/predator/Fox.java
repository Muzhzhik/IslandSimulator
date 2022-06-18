package domain.animal.predator;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Fox extends Predator {
    public Fox(AnimalConfiguration configuration) {
        super(configuration);
    }
}

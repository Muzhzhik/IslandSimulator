package domain.animal.predator;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Bear extends Predator {
    public Bear(AnimalConfiguration configuration) {
        super(configuration);
    }
}

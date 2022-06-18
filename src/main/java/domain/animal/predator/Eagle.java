package domain.animal.predator;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Eagle extends Predator {
    public Eagle(AnimalConfiguration configuration) {
        super(configuration);
    }
}

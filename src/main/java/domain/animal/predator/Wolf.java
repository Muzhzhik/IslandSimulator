package domain.animal.predator;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Wolf extends Predator {
    public Wolf(AnimalConfiguration configuration) {
        super(configuration);
    }
}

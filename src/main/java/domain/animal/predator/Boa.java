package domain.animal.predator;

import config.AnimalConfiguration;
import lombok.Getter;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Boa extends Predator {
    public Boa(AnimalConfiguration configuration) {
        super(configuration);
    }
}

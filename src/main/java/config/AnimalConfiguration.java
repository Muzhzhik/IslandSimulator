package config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Constants;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@NoArgsConstructor
@Getter
public class AnimalConfiguration {
    private String className;
    private String name;
    private double weight;
    private int maxQuantityForCell;
    private int speed;
    private double fullSatietyWeight;
    private int currentHungryPercent;
    private int startQuantity;
    private int possibleChildQuantity;
}

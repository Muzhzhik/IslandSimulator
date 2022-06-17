package domain.animal;

import lombok.Getter;
import utils.Constants;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public abstract class Animal {
    private String name = Constants.ANIMAL_DEFAULT_NAME;
    private double weight;
    private int maxQuantityForCell;
    private int speed;
    private double fullSatietyWeight;
    private int currentHungryPercent;
    private int startQuantity;
    private int possibleChildQuantity;

    public void eat() {
        System.out.println(getName() + " is eat");
    }
    public void reproduce() {
        System.out.println(getName() + " is reproduce");
    }
    public void relocate() {
        System.out.println(getName() + " is relocate");
    }
}

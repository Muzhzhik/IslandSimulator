package domain.animal;

import config.AnimalConfiguration;
import lombok.Getter;
import utils.Constants;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public abstract class Animal {
    private String name;
    private double weight;
    private int maxQuantityForCell;
    private int speed;
    private double fullSatietyWeight;
    private int currentHungryPercent;
    private int possibleChildQuantity;
    private AnimalSex sex;

    protected Animal(AnimalConfiguration configuration) {
        this.name = configuration.getName();
        this.weight = configuration.getWeight();
        this.maxQuantityForCell = configuration.getMaxQuantityForCell();
        this.speed = configuration.getSpeed();
        this.currentHungryPercent = configuration.getCurrentHungryPercent();
        this.fullSatietyWeight = configuration.getFullSatietyWeight();
        this.possibleChildQuantity = configuration.getPossibleChildQuantity();
        int random = ThreadLocalRandom.current().nextInt(2);
        this.sex = random == AnimalSex.MALE.ordinal() ? AnimalSex.MALE : AnimalSex.FEMALE;
    }

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

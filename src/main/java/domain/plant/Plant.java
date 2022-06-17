package domain.plant;

import config.PlantConfiguration;
import lombok.Getter;

import java.util.Date;
import java.util.Random;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public class Plant {
    private String name;
    private int weight;
    private int maxQuantityForCell;
    private int lifeExpectancyLimit; // seconds
    private int deathExpectancyLimit;
    private long createTime = new Date().getTime();
    private volatile boolean alive = true;

    private long deadTime = createTime;


    public Plant(PlantConfiguration configuration) {
        this.name = configuration.getName();
        this.weight = configuration.getWeight();
        this.maxQuantityForCell = configuration.getMaxQuantityForCell();
        int random = new Random().nextInt(configuration.getLifeExpectancyLimit());
        this.lifeExpectancyLimit = random == 0 ? 1 : random;
        random = new Random().nextInt(configuration.getDeathExpectancyLimit());
        this.deathExpectancyLimit = random == 0 ? 1 : random;
    }

    public void killOrRevive() {
        if (alive && plantMustDie()) {
            alive = false;
            deadTime = new Date().getTime();
        } else if (!alive && plantMustRevive()) {
            alive = true;
            createTime = new Date().getTime();
        }
    }

    private boolean plantMustDie() {
        long time = new Date().getTime() - createTime;
        return time > lifeExpectancyLimit * 1000L;
    }

    private boolean plantMustRevive() {
        long time = new Date().getTime() - deadTime;
        return time > deathExpectancyLimit * 1000L;
    }
}

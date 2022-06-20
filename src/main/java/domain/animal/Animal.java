package domain.animal;

import config.AnimalConfiguration;
import config.Configuration;
import domain.area.Area;
import domain.area.Cell;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
public abstract class Animal {
    private final String name;
    private final double weight;
    private final int maxQuantityForCell;
    private final int speed;
    private final double fullSatietyWeight;
    private int currentHungryPercent;
    private final int possibleChildQuantity;
    private final AnimalSex sex;

    Area area = Area.getInstance();
    private int currentCellId;

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
        currentHungryPercent -= 5;
    }

    public void reproduce() {
        int random = ThreadLocalRandom.current().nextInt(100);
        if (random > 70) {

        }
    }

    public void relocate() {
        int random = ThreadLocalRandom.current().nextInt(25);
        if (random > 20) {
            int previousCellId = currentCellId;
            for (int cellId : getPossibleCellsToMove()) {
                if (cellId == currentCellId) {
                    continue;
                }
                Cell cell = area.getCellById(cellId);
                if (cell.addAnimal(this)) {
                    Cell previousCell = area.getCellById(previousCellId);
                    previousCell.removeAnimal(this);
                    break;
                }
            }
        }
    }

    private List<Integer> getPossibleCellsToMove() {
        int areaWidth = Configuration.getInstance().getAreaWidth();
        int areaHeight = Configuration.getInstance().getAreaHeight();
        int maxCellId = areaHeight * areaWidth;
        List<Integer> cellsPossibleToMove = new ArrayList<>();
        if (speed > 0) {
            cellsPossibleToMove.addAll(getCellsRightAndLeftFromCurrent(currentCellId, speed));
            //up
            for (int i = 1; i <= speed; i++) {
                int possibleCellId = currentCellId - areaWidth * i;
                if (possibleCellId > 0 && possibleCellId < maxCellId) {
                    cellsPossibleToMove.add(possibleCellId);
                    cellsPossibleToMove.addAll(getCellsRightAndLeftFromCurrent(possibleCellId, speed - i));
                } else {
                    break;
                }
            }
            // down
            for (int i = 1; i <= speed; i++) {
                int possibleCellId = currentCellId + Configuration.getInstance().getAreaWidth() * i;
                if (possibleCellId > 0 && possibleCellId < maxCellId) {
                    cellsPossibleToMove.add(possibleCellId);
                    cellsPossibleToMove.addAll(getCellsRightAndLeftFromCurrent(possibleCellId, speed - i));
                } else {
                    break;
                }
            }
        }
        Collections.shuffle(cellsPossibleToMove);
        return cellsPossibleToMove;
    }

    private List<Integer> getCellsRightAndLeftFromCurrent(int currentCellId, int count) {
        int areaWidth = Configuration.getInstance().getAreaWidth();
        int areaHeight = Configuration.getInstance().getAreaHeight();
        int maxCellId = areaHeight * areaWidth;
        List<Integer> cells = new ArrayList<>();
        if (count > 0) {
            //To right
            for (int i = 1; i <= count; i++) {
                int cellId = currentCellId + i;
                if (cellId > 0 && cellId < maxCellId) {
                    cells.add(cellId);
                } else {
                    break;
                }
            }
            //To left
            for (int i = 1; i <= count; i++) {
                int cellId = currentCellId - i;
                if (cellId > 0 && cellId < maxCellId) {
                    cells.add(cellId);
                } else {
                    break;
                }
            }
        }
        return cells;
    }

    public void setCurrentCellId(int currentCellId) {
        this.currentCellId = currentCellId;
    }
}

import config.Configuration;
import controller.SimulationController;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class IslandSimulator {
    public static void main(String[] args) {
        SimulationController simulationController = new SimulationController();
        simulationController.start();
        try {
            Thread.sleep(Configuration.getInstance().getSimulationDuration() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            simulationController.stop();
        }
    }
}

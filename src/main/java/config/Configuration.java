package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.Getter;
import lombok.Setter;
import utils.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Getter
@Setter
public class Configuration {

    private static Configuration configuration;

    // Field Properties
    private int areaHeight;
    private int areaWidth;

    // Plants Properties
    private int plantQuantity;

    // Other Properties
    private int simulationDuration; //seconds

    List<PlantConfiguration> plantConfigurations;
    List<AnimalConfiguration> animalConfigurations;

    private Configuration() {};

    public static Configuration getInstance() {
        if (configuration == null) {
            ObjectMapper mapper = new YAMLMapper();
            try {
                configuration = mapper.readValue(new File(Constants.APP_CONFIGURATION_PATH),
                        Configuration.class);
            }catch (FileNotFoundException e) {
                System.out.println("Cant load configuration. File not found.");
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Cant load configuration. IO error happened.");
                System.exit(0);
            }
        }
        return configuration;
    }

    public PlantConfiguration getPlantConfigurationByName(String className) { //TODO Stream()
        PlantConfiguration result = null;
        for(PlantConfiguration plantConfiguration : plantConfigurations) {
            if (plantConfiguration.getClassName().equals(className)) {
                result = plantConfiguration;
                break;
            }
        }
        return result;
    }

    public AnimalConfiguration getAnimalConfigurationByName(String className) { //TODO Stream()
        AnimalConfiguration result = null;
        for(AnimalConfiguration animalConfiguration : animalConfigurations) {
            if (animalConfiguration.getClassName().equals(className)) {
                result = animalConfiguration;
                break;
            }
        }
        return result;
    }
}

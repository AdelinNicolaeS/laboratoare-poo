package dataprocessing;

import main.Utils;
import storage.DataRepository;

public class StepCountStrategyFactory {
    public StepCountStrategy createStrategy(String strategyType, DataRepository dataRepository) {
        if(strategyType.equals(Utils.BASIC_STRATEGY)) {
            return new BasicStepCountStrategy();
        } else {
            return new FilteredStepCountStrategy();
        }
    }
}

package dataprocessing;

import main.Utils;
import storage.SensorData;

import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy{
    @Override
    public int getTotalSteps(List<SensorData> sensorDataList) {
        if(sensorDataList.size() == 0) {
            return 0;
        }
        int total = sensorDataList.get(0).getStepsCount();
        for(int i = 1; i < sensorDataList.size(); i++) {
            if(sensorDataList.get(i).getTimestamp() - sensorDataList.get(i - 1).getTimestamp() >= Utils.TIME_FOR_MAX_DIFF
                    && sensorDataList.get(i).getStepsCount() > 0
                    && sensorDataList.get(i).getStepsCount() < Utils.MAX_DIFF_STEPS_CONSECUTIVE_RECORDS) {
                total += sensorDataList.get(i).getStepsCount();
            }
        }
        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "Pentru FilteredStepCountStrategy avem suma = ";
    }
}

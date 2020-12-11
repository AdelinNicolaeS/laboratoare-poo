package dataprocessing;

import storage.SensorData;

import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy{

    @Override
    public int getTotalSteps(List<SensorData> sensorDataList) {
        int total = 0;
        for(SensorData sensorData : sensorDataList) {
            total += sensorData.getStepsCount();
        }
        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "Pentru BasicStepCountStrategy avem suma = ";
    }
}

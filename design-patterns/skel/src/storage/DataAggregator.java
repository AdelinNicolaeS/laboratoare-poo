package storage;

import dataprocessing.StepCountStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DataAggregator implements Observer {
    List<SensorData> sensorDataList = new ArrayList<>();
    StepCountStrategy strategy;
    @Override
    public void update(Observable observable, Object o) {
        sensorDataList.add((SensorData) o);
        applyStrategy();
    }

    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    public void applyStrategy() {
        int total = strategy.getTotalSteps(sensorDataList);
        System.out.println(strategy.getStrategyDescription() + total);
    }
}

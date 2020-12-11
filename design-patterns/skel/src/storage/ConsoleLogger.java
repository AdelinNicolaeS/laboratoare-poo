package storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {
    List<SensorData> sensorDataList = new ArrayList<>();
    @Override
    public void update(Observable observable, Object o) {
        sensorDataList.add((SensorData) o);
        printChanges();
    }
    public void printChanges() {
        System.out.println(sensorDataList.get(sensorDataList.size() - 1));
    }
}

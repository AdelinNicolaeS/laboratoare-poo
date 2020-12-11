package storage;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable { // TODO make this an Observable
    private List<SensorData> sensorDataList = new ArrayList<>();
    public void addData(SensorData dataRecord){
        // TODO
        // store data (e.g. in a List)
        // notifiy observers
        sensorDataList.add(dataRecord);
        setChanged();
        notifyObservers(dataRecord);
    }

    public List<SensorData> getSensorDataList() {
        return sensorDataList;
    }
    // TODO implement a method to get the stored data (needed by the strategies)
}



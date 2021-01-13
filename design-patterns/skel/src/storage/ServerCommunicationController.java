package storage;

import communication.ServerMessage;
import main.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    List<SensorData> sensorDataList = new ArrayList<>();
    @Override
    public void update(Observable observable, Object o) {
        sensorDataList.add((SensorData) o);
        buildMessage();
    }
    public void buildMessage() {
        SensorData last = sensorDataList.get(sensorDataList.size()-1);
        ServerMessage serverMessage = new ServerMessage(last.getStepsCount(), Utils.getClientId(), last.getTimestamp());
        System.out.println(serverMessage);
    }
}

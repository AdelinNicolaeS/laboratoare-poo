package main;

import dataprocessing.BasicStepCountStrategy;
import dataprocessing.FilteredStepCountStrategy;
import dataprocessing.StepCountStrategy;
import storage.*;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();
        // TODO: use the StepCountStrategyFactory to create a strategy
        StepCountStrategy strategy;
        if(strategyType.equals(Utils.BASIC_STRATEGY)) {
            strategy = new BasicStepCountStrategy();
        } else if(strategyType.equals(Utils.FILTERED_STRATEGY)) {
            strategy = new FilteredStepCountStrategy();
        } else {
            System.out.println("Unknown Strategy");
            return;
        }

        // TODO: add observers to the dataRepository
        // don't forget to provide the strategy to the DataAggregator observer
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ServerCommunicationController server = new ServerCommunicationController();
        DataAggregator dataAggregator = new DataAggregator(strategy);
        dataRepository.addObserver(consoleLogger);
        dataRepository.addObserver(server);
        dataRepository.addObserver(dataAggregator);

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        // TODO: after the first successful run, change this to baseTimestamp + 40000 and check the result
        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5 + 40000));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6 + 40000));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600 + 40000));
        System.out.println();
        /*
          am testat pentru cazurile initiale, dupa care am adaugat +40000 la al patrulea sensor data
          din lista, dupa care la toate incepand cu al patrulea, dupa care doar la al cincilea ca sa
          testez pentru filtered
         */
    }
}

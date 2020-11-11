package first;

public class CounterOutTask implements Task {
    private static int counter = 0;

    public void execute() {
        System.out.println("Contorul este " + counter);
    }

    public CounterOutTask() {
        counter++;
        execute();
    }

    public static int getCounter() {
        return counter;
    }
}

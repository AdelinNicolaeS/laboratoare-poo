package first;

import java.util.Random;

public class RandomOutTask implements Task {
    private int rand_int;

    public void execute() {
        System.out.println("Numarul generate random este " + rand_int);
    }

    public RandomOutTask() {
        Random rand = new Random();
        rand_int = rand.nextInt(1000);
    }
}

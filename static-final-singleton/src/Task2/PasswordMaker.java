package Task2;

import java.util.Random;

public class PasswordMaker {
    private final int MAGIC_NUMBER = 8;
    Task2.RandomStringGenerator rand1 = new Task2.RandomStringGenerator(20, "abcdefghijklmnopqrstuvwxyz");
    private final String MAGIC_STRING = rand1.next();
    private String name;
    private static PasswordMaker instance = null;
    static {
        instance = new PasswordMaker();
        System.out.println("It worked");
    }
    private static int instanceCount = 0;
    /*
        instanceCount trebuie sa fie static deoarece numara de cate ori
        a fost folosita o metoda statica, deci e independenta de instanta
        in sine, numarand cate instante au fost create de fapt
     */

    public static int getInstanceCount() {
        return instanceCount;
    }

    private PasswordMaker() {
    }

    public static PasswordMaker getInstance() {
        instanceCount++;
        return instance;
    }

    public int getMAGIC_NUMBER() {
        return MAGIC_NUMBER;
    }

    public String getMAGIC_STRING() {
        return MAGIC_STRING;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        Task2.RandomStringGenerator rand2 = new Task2.RandomStringGenerator(10, MAGIC_STRING);
        String alphabet = rand2.next();
        Task2.RandomStringGenerator rand3 = new Task2.RandomStringGenerator(10, alphabet);
        String s1 = rand3.next();
        Random rand4 = new Random();
        int nr = rand4.nextInt(100);
        nr = nr + name.length();
        String s2 = String.valueOf(nr);
        return s1.concat(s2);
    }
}

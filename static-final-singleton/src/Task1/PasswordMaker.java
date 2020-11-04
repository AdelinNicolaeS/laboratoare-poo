package Task1;

import java.util.Random;

public class PasswordMaker {
    private final int MAGIC_NUMBER = 8;
    RandomStringGenerator rand1 = new RandomStringGenerator(20, "abcdefghijklmnopqrstuvwxyz");
    private final String MAGIC_STRING = rand1.next();
    private String name;
    public PasswordMaker(String name) {
        this.name = name;
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
        RandomStringGenerator rand2 = new RandomStringGenerator(10, MAGIC_STRING);
        String alphabet = rand2.next();
        RandomStringGenerator rand3 = new RandomStringGenerator(10, alphabet);
        String s1 = rand3.next();
        Random rand4 = new Random();
        int nr = rand4.nextInt(100) + name.length();
        String s2 = String.valueOf(nr);
        String result = s1.concat(s2);
        return  result;
    }
}

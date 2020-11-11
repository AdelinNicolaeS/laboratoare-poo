package Task1;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        PasswordMaker maker = new PasswordMaker("Maria");
        System.out.println(maker.getMAGIC_NUMBER());
        System.out.println(maker.getMAGIC_STRING());
        System.out.println(maker.getName());
        System.out.println(maker.getPassword());
    }
}

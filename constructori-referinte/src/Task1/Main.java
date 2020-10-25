package Task1;

public class Main {
    public static void main(String[] args) {
        Complex nr1 = new Complex(2, 3);
        nr1.showNumber();

        Complex nr2 = new Complex();
        nr2.showNumber();

        Complex nr3 = new Complex(nr1);
        nr3.showNumber();

        Complex nr4 = new Complex(3, 5);
        nr4.showNumber();

        nr4.addWithComplex(nr1);
        nr4.showNumber();
    }
}

package Task1;

public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) { // primul constructor
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {    // al doilea constructor
        this(0, 0);
    }
    public Complex(Complex number) { // copy constructor
        this.real = number.real;
        this.imaginary = number.imaginary;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }
    public void addWithComplex(Complex number) {
        real += number.getReal();
        imaginary += number.getImaginary();
    }
    public void showNumber() {
        System.out.println("numarul este " + this.getReal() + " + i * " + this.getImaginary());
    }
}

public class Lindt extends CandyBox {
    protected float length;
    protected float width;
    protected float height;

    public Lindt() {
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return super.toString() + " has volume " + getVolume();
    }

    public void PrintLindtDim () {
        System.out.println("Dimensiunile sunt length " + length + ", width " + width + " si heigth " + height);
    }

    public void Print() {
        System.out.println("Dimensiunile sunt length " + length + ", width " + width + " si heigth " + height);
    }
}

public class Baravelli extends CandyBox {
    protected float radius;
    protected float height;

    public Baravelli() {
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) Math.PI * radius * radius * height;
    }

    public String toString() {
        return super.toString() + " has volume " + getVolume();
    }

    public void printBaravelliDim () {
        System.out.println("Dimensiunile sunt radius " + radius + " si height " + height);
    }

    public void print() {
        System.out.println("Dimensiunile sunt radius " + radius + " si height " + height);
    }
}

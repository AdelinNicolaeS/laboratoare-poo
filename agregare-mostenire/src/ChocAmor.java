public class ChocAmor extends CandyBox {
    protected float length;

    public ChocAmor() {
    }

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return length * length * length;
    }

    public String toString() {
        return super.toString() + " has volume " + getVolume();
    }

    public void printChocAmorDim () {
        System.out.println("Dimensiunea sunt length " + length);
    }

    public void print () {
        System.out.println("Dimensiunea sunt length " + length);
    }

}

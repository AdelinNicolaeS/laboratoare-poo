import java.util.Objects;

public class CandyBox {
    protected String flavor;
    protected String origin;

    public CandyBox() {
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }
    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "The " + origin + " " + flavor ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandyBox)) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(flavor, candyBox.flavor) &&
                Objects.equals(origin, candyBox.origin);
    }
    public void Print() {
        // adaugat pentru a evita folosirea instanceof
    }

}

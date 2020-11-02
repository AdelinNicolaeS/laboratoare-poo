import java.util.ArrayList;

public class CandyBag {
    private ArrayList<CandyBox> bag;

    public CandyBag() {
        bag = new ArrayList<CandyBox>();
    }

    public ArrayList<CandyBox> getBag() {
        return bag;
    }

    public void setBag(ArrayList<CandyBox> bag) {
        this.bag = bag;
    }
}

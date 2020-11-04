package Task34;

import java.util.ArrayList;

public class MyImmutableArray {
    private final ArrayList<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> immutableArray) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer aux : immutableArray) {
            temp.add(aux);
        }
        this.immutableArray = temp;
    }

    public ArrayList<Integer> getImmutableArray() {
        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer aux : immutableArray) {
            temp.add(aux);
        }
        return temp;
    }
}
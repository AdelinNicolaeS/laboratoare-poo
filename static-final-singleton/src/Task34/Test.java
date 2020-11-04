package Task34;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        final ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(3);
        arr.add(5);
        Task34.MyImmutableArray array = new MyImmutableArray(arr);
        System.out.println(array.getImmutableArray());
        // incercam fara succes sa adaugam valori noi in arraylist
        array.getImmutableArray().add(1);
        array.getImmutableArray().add(2);
        array.getImmutableArray().add(3);
        System.out.println(array.getImmutableArray());

    }
}
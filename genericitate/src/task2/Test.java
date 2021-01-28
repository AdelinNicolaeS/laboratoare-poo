package task2;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static Summable addReallyAll(Collection<? extends Summable> collection) {
        if (collection.isEmpty()) {
            return null;
        }
        Summable first = collection.iterator().next();
        for (Summable summable : collection) {
            if (!summable.equals(first)) {
                first.addValue(summable);
            }
        }
        return first;
    }
    public static void main(String[] args) {
        ArrayList<Summable> summables = new ArrayList<>();
        summables.add(new MyMatrix(5));
        summables.add(new MyMatrix(0));
        summables.add(new MyMatrix(100));
        System.out.println(addReallyAll(summables));
        summables.clear();
        summables.add(new MyVector3(0, 3, 4));
        summables.add(new MyVector3(5, 1, 44));
        summables.add(new MyVector3(-1, 56, 0));
        System.out.println(addReallyAll(summables));
        summables.clear();
        System.out.println(addReallyAll(summables));

    }
}

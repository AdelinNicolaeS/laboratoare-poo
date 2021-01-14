package task2;

public class MyVector3 implements Summable {
    private int[] array;

    MyVector3(int t1, int t2, int t3) {
        array = new int[3];
        array[0] = t1;
        array[1] = t2;
        array[2] = t3;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyVector3{");
        sb.append("array=");
        if (array == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < array.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(array[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void addValue(Summable value) {
        for (int i = 0; i < 3; ++i) {
            array[i] += ((MyVector3)value).array[i];
        }
    }
}

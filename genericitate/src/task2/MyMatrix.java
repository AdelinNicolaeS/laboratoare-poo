package task2;

public class MyMatrix implements Summable {
    private int[][] matrix = new int[4][4];

    public MyMatrix(int n) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                matrix[i][j] = n + i + j;
            }
        }
    }

    @Override
    public String toString() {
        String out = "";
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                out = out + matrix[i][j] + "\t";
            }
            out = out + "\n";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }

    @Override
    public void addValue(Summable instance) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                matrix[i][j] += ((MyMatrix) instance).matrix[i][j];
            }
        }
    }
}

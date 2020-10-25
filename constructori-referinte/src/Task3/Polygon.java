package Task3;

public class Polygon {
    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Polygon(int n) {
        points = new Point[n];
    }

    public Polygon(float[] numbers) {
        this(numbers.length/2);
        int j = 0;
            for(int i = 0; i < numbers.length - 1; i = i + 2) {
                Point aux = new Point(numbers[i], numbers[i + 1]);
                points[j] = aux;
                j++;
            }
    }

    public void printPolygon() {
        for(int i = 0; i < points.length; i++) {
            System.out.println(points[i].toString());
        }
    }
}

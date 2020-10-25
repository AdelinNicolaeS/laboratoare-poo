package Task3;

public class Point {
    private float x;
    private float y;

    public Point (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void changeCoords(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public String toString() {
        return  "(" + x +
                ", " + y +
                ')';
    }
}

package third;

public class Operation implements Div, Minus, Plus, Mult {
    private float number;

    public Operation(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    @Override
    public void div(float number) {
        if(number != 0) {
            this.number /= number;
        }
    }

    @Override
    public void minus(float number) {
        this.number -= number;
    }

    @Override
    public void plus(float number) {
        this.number += number;
    }

    @Override
    public void mult(float number) {
        this.number *= number;
    }
}

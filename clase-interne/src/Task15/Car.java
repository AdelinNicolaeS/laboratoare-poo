package Task15;

public class Car {
    private Integer price;
    private CarType type;
    private Integer year;

    public Car(Integer price, CarType type, Integer year) {
        this.price = price;
        this.type = type;
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("price=").append(price);
        sb.append(", type=").append(type);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}

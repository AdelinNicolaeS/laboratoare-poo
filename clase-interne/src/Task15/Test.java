/*
    Dupa ce am rulat in terminal comanda javac, au fost generate urmatoarele
    Car.class                       Dealership.class                    'Test$1.class'
    Car.java                        'Dealership$DealerOffer.class'      'Test$2.class'
    CarType.class                   Dealership.java                     'Test$3.class'
    CarType.java                    'Dealership$SpecialOffer.class'     Test.class
    'Dealership$1.class'            Offer.class                         Test.java
    'Dealership$BrandOffer.class'   Offer.java
    Dintre acestea, afarente celor 3 clase interne create in Test.java au aparut Test$1.class, Test$2.class, Test$3.class.
*/

package Task15;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car(9000, CarType.DACIA, 2016);
        Car car2 = new Car(15000, CarType.RENAULT, 2018);
        Car car3 = new Car(30000, CarType.BMW, 2013);

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
        System.out.println();

        Dealership dealership = new Dealership();
        dealership.getFinalPrice(car1);
        dealership.negotiate(car1, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 100;
            }
        });
        System.out.println();
        dealership.getFinalPrice(car2);
        dealership.negotiate(car2, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 100;
            }
        });
        System.out.println();
        dealership.getFinalPrice(car3);
        dealership.negotiate(car3, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 100;
            }
        });
        System.out.println();

        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);
        carArrayList.forEach((car -> System.out.println(car.toString())));
        System.out.println();
        carArrayList.removeIf(car -> car.getPrice() > 10000);
        carArrayList.forEach((car -> System.out.println(car.toString())));
    }
}

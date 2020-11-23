package Task15;

import java.util.Random;

public class Dealership {
    private class BrandOffer implements Offer {

        @Override
        public int getDiscount(Car car) {
            if(car.getType() == CarType.DACIA) {
                return (int) (0.05 * car.getPrice());
            }
            return 0;
        }
    }
    private class DealerOffer implements Offer {

        @Override
        public int getDiscount(Car car) {
            return 100 * (2020 - car.getYear());
        }
    }
    private class SpecialOffer implements Offer {

        @Override
        public int getDiscount(Car car) {
            Random rand = new Random();
            return rand.nextInt(300);
        }
    }

    public void getFinalPrice(Car car) {
        System.out.println(car.toString());
        System.out.println("Initial price: " + car.getPrice() + " euros");
        BrandOffer offer1 = new BrandOffer();
        DealerOffer offer2 = new DealerOffer();
        SpecialOffer offer3 = new SpecialOffer();
        int discount1 = offer1.getDiscount(car);
        int discount2 = offer2.getDiscount(car);
        int discount3 = offer3.getDiscount(car);
        System.out.println("Applying Brand discount: " + discount1 + " euros");
        System.out.println("Applying Dealer discount: " + discount2 + " euros");
        System.out.println("Applying Special discount: " + discount3 + " euros");
        car.setPrice(car.getPrice() - discount1 - discount2 - discount3);
        System.out.println("Final price: " + car.getPrice() + " euros");
    }
    void negotiate(Car car, Offer offer){
        Random rand = new Random();
        int randInt = rand.nextInt(2);
        int discount = offer.getDiscount(car);
        if(randInt == 1) {
            System.out.println("Applying Client discount: " + discount + " euros");
            car.setPrice(car.getPrice() - discount);
        } else {
            System.out.println("Applying Client discount: 0 euros");
        }
        System.out.println("Final price after negotiation: " + car.getPrice() + " euros");
    }
}

package Task0;

interface Engine {
    public int getFuelCapacity();
}

class Car1 {
    class OttoEngine implements Engine {
        private int fuelCapacity;

        public OttoEngine(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }

    public OttoEngine getEngine() {
        OttoEngine engine = new OttoEngine(11);
        return engine;
    }
}

class Car2 {
    public Engine getEngine(int fuelCapacity) {
        return new Engine () {
            private int fuelCapacity = 11;

            public int getFuelCapacity() {
                return fuelCapacity;
            }
        };
    }
}

public class Test {
    public static void main(String[] args) {
        Car1 car1 = new Car1();
        Car1.OttoEngine firstEngine = car1.getEngine();
        Car1.OttoEngine secondEngine = car1.new OttoEngine(10);
        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());



        Car2 car2 = new Car2();
        Engine engine1 = car2.getEngine(10);
        Engine engine2 = car2.getEngine(11);
        System.out.println(engine1.getFuelCapacity()); // afiseaza tot 11
        System.out.println(engine2.getFuelCapacity());
    }
}
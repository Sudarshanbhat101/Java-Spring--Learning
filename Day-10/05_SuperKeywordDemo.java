/**
 * super: call parent constructor, access parent fields/methods from subclass.
 */
class VehicleSuper {
    protected String brand = "Generic";

    VehicleSuper() {
        System.out.println("VehicleSuper constructor");
    }

    VehicleSuper(String brand) {
        this.brand = brand;
        System.out.println("VehicleSuper(String) brand=" + brand);
    }

    void start() {
        System.out.println(brand + " starting");
    }
}

class CarSuper extends VehicleSuper {
    private final int wheels;

    CarSuper(String brand, int wheels) {
        super(brand); // must be first statement — runs parent constructor
        this.wheels = wheels;
    }

    @Override
    void start() {
        super.start(); // parent behavior, then extend
        System.out.println("Car with " + wheels + " wheels ready");
    }
}

class SuperKeywordDemo {

    public static void main(String[] args) {
        CarSuper car = new CarSuper("Toyota", 4);
        car.start();
        System.out.println("brand via inheritance: " + car.brand);
    }
}

class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    void openTrunk() {
        System.out.println("Car trunk opened");
    }
}

class SingleInheritanceDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();      // inherited from Vehicle
        car.openTrunk();  // Car-specific method
    }
}

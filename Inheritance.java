class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;

    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: TZS " + price);
    }

    public void startEngine() {
        System.out.println(brand + " " + model + " engine started");
    }

    public void stopEngine() {
        System.out.println(brand + " " + model + " engine stopped");
    }
}

class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String brand, String model, int year, double price, int numDoors, String fuelType) {
        super(brand, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors: " + numDoors);
        System.out.println("Fuel Type: " + fuelType);
    }

    public void honk() {
        System.out.println(brand + " " + model + " says: Beep! Beep!");
    }

    public void openTrunk() {
        System.out.println("Opening trunk of " + brand + " " + model);
    }
}

class Motorcycle extends Vehicle {
    private int engineCC;
    private boolean hasHelmetStorage;

    public Motorcycle(String brand, String model, int year, double price, int engineCC, boolean hasHelmetStorage) {
        super(brand, model, year, price);
        this.engineCC = engineCC;
        this.hasHelmetStorage = hasHelmetStorage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine: " + engineCC + "cc");
        System.out.println("Helmet Storage: " + (hasHelmetStorage ? "Yes" : "No"));
    }

    public void wheelie() {
        System.out.println(brand + " " + model + " is doing a wheelie!");
    }

    public void kickStart() {
        System.out.println("Kick starting " + brand + " " + model);
    }
}

class ElectricCar extends Car {
    private double batteryCapacity;
    private int range;

    public ElectricCar(String brand, String model, int year, double price, int numDoors, String fuelType, double batteryCapacity, int range) {
        super(brand, model, year, price, numDoors, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + " electric motor activated silently");
    }

    public void charge() {
        System.out.println("Charging " + brand + " " + model + "... Battery: " + batteryCapacity + " kWh");
    }

    public void displayBatteryStatus() {
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Range: " + range + " km");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== VEHICLE HIERARCHY TEST ===\n");

        Car car = new Car("Toyota", "Corolla", 2023, 45000000, 4, "Petrol");
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 2022, 15000000, 500, false);
        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 2024, 85000000, 4, "Electric", 75.0, 450);

        System.out.println("--- Testing Car ---");
        car.displayInfo();
        car.startEngine();
        car.honk();
        car.openTrunk();
        car.stopEngine();

        System.out.println("\n--- Testing Motorcycle ---");
        motorcycle.displayInfo();
        motorcycle.startEngine();
        motorcycle.wheelie();
        motorcycle.kickStart();
        motorcycle.stopEngine();

        System.out.println("\n--- Testing Electric Car ---");
        electricCar.displayInfo();
        electricCar.startEngine();
        electricCar.charge();
        electricCar.displayBatteryStatus();
        electricCar.honk();
        electricCar.stopEngine();

        System.out.println("\n--- Polymorphism Demo ---");
        Vehicle[] vehicles = {car, motorcycle, electricCar};
        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.startEngine();
            System.out.println();
        }

        System.out.println("\n=== END OF TEST ===");
    }
}
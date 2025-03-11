// Base class Vehicle
class Vehicle {
    String make;
    String model;
    String year;

    // Constructor
    public Vehicle(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Method to calculate insurance premium
    public double calculateInsurancePremium() {
        // Default premium for a basic vehicle (can be overridden by subclasses)
        return 1000.0;
    }
}

// Subclass Car that extends Vehicle
class Car extends Vehicle {
    int numberOfDoors;

    // Constructor
    public Car(String make, String model, String year, int numberOfDoors) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    // Override method to display car details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    // Override method to calculate insurance premium for a car
    @Override
    public double calculateInsurancePremium() {
        double basePremium = super.calculateInsurancePremium();
        // Premium increases based on the number of doors (example logic)
        return basePremium + (numberOfDoors * 50);
    }
}

// Subclass Truck that extends Vehicle
class Truck extends Vehicle {
    double cargoCapacity;

    // Constructor
    public Truck(String make, String model, String year, double cargoCapacity) {
        super(make, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    // Override method to display truck details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }

    // Override method to calculate insurance premium for a truck
    @Override
    public double calculateInsurancePremium() {
        double basePremium = super.calculateInsurancePremium();
        // Premium increases based on the cargo capacity (example logic)
        return basePremium + (cargoCapacity * 100);
    }
}

// Main class to test the implementation
public class VehicleType {
    public static void main(String[] args) {
        // Create instances of Car and Truck
        Car car = new Car("Toyota", "Camry", "2022", 4);
        Truck truck = new Truck("Ford", "F-150", "2021", 2.5);

        // Display details and calculate insurance premiums for each vehicle
        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println("Insurance Premium: $" + car.calculateInsurancePremium());

        System.out.println("\nTruck Details:");
        truck.displayDetails();
        System.out.println("Insurance Premium: $" + truck.calculateInsurancePremium());
    }
}


public class vehiclemain {
	
	public static void main(String[] args) {
        Car car = new Car(120, 50, 15);
        car.displayDetails();
        System.out.println("Car Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l\n");

        // Now if you want to work with a Bike or Truck, you'll need separate code:
        Bike bike = new Bike(80, 10, 40);
        bike.displayDetails();
        System.out.println("Bike Fuel Efficiency: " + bike.calculateFuelEfficiency() + " km/l\n");
        
        Truck truck = new Truck(120, 50, 15);
        car.displayDetails();
        System.out.println("Truck Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l\n");
    }


}

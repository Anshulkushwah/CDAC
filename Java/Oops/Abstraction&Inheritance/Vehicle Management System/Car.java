
public class Car extends vehicle {
	
	public Car(double speed, double fuelCapacity, double mileage) {
        super(speed, fuelCapacity, mileage);
    }
	
	@Override
	public double calculateFuelEfficiency() {
        // Assume fuel efficiency is just mileage in km per liter.
		double correctionFactor = 0.85; // Trucks are less fuel-efficient
        return mileage * correctionFactor;
    }

}

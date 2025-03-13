
public class Bike extends vehicle {
	
	public Bike(double speed, double fuelCapacity, double mileage) {
        super(speed, fuelCapacity, mileage);
    }
	
	@Override
	public double calculateFuelEfficiency() {
		double correctionFactor = 0.99; // Trucks are less fuel-efficient
        return mileage * correctionFactor;
    }

}


public class Truck extends vehicle {
	
	public Truck(double speed, double fuelCapacity, double mileage) {
        super(speed, fuelCapacity, mileage);
    }
	
	@Override
	public double calculateFuelEfficiency() {
		double correctionFactor = 0.7; // Trucks are less fuel-efficient
        return mileage * correctionFactor;
    }
}

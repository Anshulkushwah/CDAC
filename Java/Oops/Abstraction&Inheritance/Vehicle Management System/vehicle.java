
public abstract class vehicle {

	double  speed;
	double  fuelCapacity;
	double  mileage;
	
	public vehicle(double  speed,double  fuelCapacity,double  mileage) {
		this.speed = speed;
		this.fuelCapacity = fuelCapacity;
		this.mileage = mileage;
	}
		
	// Abstract method for calculating fuel efficiency
		public abstract double calculateFuelEfficiency();
		
		public void displayDetails() {
	        System.out.println("Speed: " + speed + " km/h");
	        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
	        System.out.println("Mileage: " + mileage + " km/l");
	    }
}

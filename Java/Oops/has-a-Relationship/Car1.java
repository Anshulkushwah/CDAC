
public class Car1 {
	
	String brand;
	String model;
	Engine engine;
	
	public Car1(String brand,String model,Engine engine) {
		this.brand = brand;
		this.model = model;
		this.engine = engine;
	}
	
	public void startCar() {
		this.engine.startEngine();
	}
	
	
	public static void main(String[] args) {
		Engine e = new Engine("Petrol",1010);
		
		Car1 c = new Car1("TATA","Nexon",e);
		
		// Start the car
        c.startCar();
		
	}

}

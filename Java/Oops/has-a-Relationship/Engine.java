
public class Engine {
	String engineType;
	int horsePower;
	
    public Engine(String engineType, int horsePower) {
        this.engineType = engineType;
        this.horsePower = horsePower;
    }
	
	void startEngine() {
		System.out.print("Engine started");
	}
}

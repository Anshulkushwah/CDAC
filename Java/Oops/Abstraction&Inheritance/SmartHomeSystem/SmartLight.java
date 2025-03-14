public class SmartLight implements SmartDevice {
    private boolean isOn;
    private int brightness;
    
    public SmartLight() {
        this.isOn = false;
        this.brightness = 0;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartLight is turned on");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartLight is turned off");
    }

    @Override
    public void adjustSettings(int settings) {
    	this.brightness = settings;
        System.out.println("SmartLight brightness set to " + brightness);
    }
}

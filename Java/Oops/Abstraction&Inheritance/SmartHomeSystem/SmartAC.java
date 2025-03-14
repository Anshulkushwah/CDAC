public class SmartAC implements SmartDevice {
    private boolean isOn;
    private int temperature; // Temperature level in °C

    public SmartAC() {
        this.isOn = false;
        this.temperature = 24; // Default temperature
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartAC is turned on");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartAC is turned off");
    }

    @Override
    public void adjustSettings(int temperature) {
        this.temperature = temperature;
        System.out.println("SmartAC temperature set to " + temperature + "°C");
    }
}

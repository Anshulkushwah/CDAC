public class SmartFan implements SmartDevice {
    private boolean isOn;
    private int speed; // Speed level (1 to 5)

    public SmartFan() {
        this.isOn = false;
        this.speed = 0;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartFan is turned on");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartFan is turned off");
    }

    @Override
    public void adjustSettings(int speed) {
        this.speed = speed;
        System.out.println("SmartFan speed set to " + speed);
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        // Create instances of the devices
        SmartDevice light = new SmartLight();
        SmartDevice fan = new SmartFan();
        SmartDevice ac = new SmartAC();

        // Turn on the devices and adjust settings
        light.turnOn();
        light.adjustSettings(80); // Brightness set to 80

        fan.turnOn();
        fan.adjustSettings(3); // Fan speed set to 3

        ac.turnOn();
        ac.adjustSettings(22); // AC temperature set to 22°C

        // Turn off the devices
        light.turnOff();
        fan.turnOff();
        ac.turnOff();
    }
}

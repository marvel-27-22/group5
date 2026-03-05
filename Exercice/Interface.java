interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}

interface Dimmable {
    void setBrightness(int level);
    int getBrightness();
    void dim();
    void brighten();
}

interface TemperatureControllable {
    void setTemperature(double temp);
    double getTemperature();
    void increaseTemp(double amount);
    void decreaseTemp(double amount);
}

interface Schedulable {
    void scheduleOn(String time);
    void scheduleOff(String time);
    String getSchedule();
    void cancelSchedule();
}

interface EnergyMonitor {
    double getEnergyUsage();
    double getEstimatedCost(double ratePerKwh);
    void resetUsage();
}

class SmartLight implements Switchable, Dimmable, Schedulable, EnergyMonitor {
    private String name;
    private boolean isOn = false;
    private int brightness = 50;
    private String schOn = "--", schOff = "--";
    private double energyUsed = 0.5;

    public SmartLight(String name) { this.name = name; }

    public void turnOn() { isOn = true; System.out.println(name + " turned ON"); }
    public void turnOff() { isOn = false; System.out.println(name + " turned OFF"); }
    public boolean isOn() { return isOn; }

    public void setBrightness(int level) { brightness = level; }
    public int getBrightness() { return brightness; }
    public void dim() { brightness -= 10; }
    public void brighten() { brightness += 10; }

    public void scheduleOn(String time) { schOn = time; }
    public void scheduleOff(String time) { schOff = time; }
    public String getSchedule() { return "ON: " + schOn + " | OFF: " + schOff; }
    public void cancelSchedule() { schOn = "--"; schOff = "--"; }

    public double getEnergyUsage() { return energyUsed; }
    public double getEstimatedCost(double rate) { return energyUsed * rate; }
    public void resetUsage() { energyUsed = 0; }

    public void displayStatus() {
        System.out.println("Light: " + name + " | Status: " + (isOn ? "ON" : "OFF") + 
                           " | Brightness: " + brightness + "% | " + getSchedule());
    }
}

class SmartAC implements Switchable, TemperatureControllable, Schedulable, EnergyMonitor {
    private String name;
    private boolean isOn = false;
    private double temp = 24.0;
    private String schOn = "--", schOff = "--";
    private String mode = "cooling";
    private int fanSpeed = 3;

    public SmartAC(String name) { this.name = name; }

    public void turnOn() { isOn = true; System.out.println(name + " AC ON"); }
    public void turnOff() { isOn = false; System.out.println(name + " AC OFF"); }
    public boolean isOn() { return isOn; }

    public void setTemperature(double t) { temp = t; }
    public double getTemperature() { return temp; }
    public void increaseTemp(double a) { temp += a; }
    public void decreaseTemp(double a) { temp -= a; }

    public void scheduleOn(String time) { schOn = time; }
    public void scheduleOff(String time) { schOff = time; }
    public String getSchedule() { return "ON: " + schOn + " | OFF: " + schOff; }
    public void cancelSchedule() { schOn = "--"; schOff = "--"; }

    public double getEnergyUsage() { return 2.5; }
    public double getEstimatedCost(double rate) { return 2.5 * rate; }
    public void resetUsage() {}

    public void setMode(String m) { mode = m; }
    public void setFanSpeed(int s) { fanSpeed = s; }

    public void displayStatus() {
        System.out.println("AC: " + name + " | Temp: " + temp + "C | Mode: " + mode + " | Fan: " + fanSpeed);
    }
}

class SmartTV implements Switchable, Schedulable, EnergyMonitor {
    private String name;
    private boolean isOn = false;
    private int volume = 20;
    private int channel = 1;

    public SmartTV(String name) { this.name = name; }

    public void turnOn() { isOn = true; System.out.println(name + " TV ON"); }
    public void turnOff() { isOn = false; System.out.println(name + " TV OFF"); }
    public boolean isOn() { return isOn; }

    public void scheduleOn(String t) {}
    public void scheduleOff(String t) {}
    public String getSchedule() { return "No schedule"; }
    public void cancelSchedule() {}

    public double getEnergyUsage() { return 0.3; }
    public double getEstimatedCost(double r) { return 0.3 * r; }
    public void resetUsage() {}

    public void setVolume(int v) { volume = v; }
    public void setChannel(int c) { channel = c; }

    public void displayStatus() {
        System.out.println("TV: " + name + " | Channel: " + channel + " | Volume: " + volume);
    }
}

class SmartHomeController {
    private Switchable[] devices;
    private int count = 0;

    public SmartHomeController(int size) { devices = new Switchable[size]; }

    public void addDevice(Switchable device) {
        if (count < devices.length) { devices[count++] = device; }
    }

    public void turnAllOff() {
        for (int i = 0; i < count; i++) { devices[i].turnOff(); }
    }

    public void turnAllOn() {
        for (int i = 0; i < count; i++) { devices[i].turnOn(); }
    }

    public double getTotalEnergyUsage() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (devices[i] instanceof EnergyMonitor) {
                total += ((EnergyMonitor) devices[i]).getEnergyUsage();
            }
        }
        return total;
    }

    public void dimAllLights(int level) {
        for (int i = 0; i < count; i++) {
            if (devices[i] instanceof Dimmable) {
                ((Dimmable) devices[i]).setBrightness(level);
            }
        }
    }

    public void displayAllDevices() {
        for (int i = 0; i < count; i++) {
            if (devices[i] instanceof SmartLight) ((SmartLight)devices[i]).displayStatus();
            else if (devices[i] instanceof SmartAC) ((SmartAC)devices[i]).displayStatus();
            else if (devices[i] instanceof SmartTV) ((SmartTV)devices[i]).displayStatus();
        }
    }
}

public class Interface {
    public static void main(String[] args) {
        System.out.println("=== SMART HOME SYSTEM TEST ===\n");

        SmartLight light = new SmartLight("Living Room Light");
        SmartAC ac = new SmartAC("Living Room AC");
        SmartTV tv = new SmartTV("Main TV");

        SmartHomeController controller = new SmartHomeController(5);
        controller.addDevice(light);
        controller.addDevice(ac);
        controller.addDevice(tv);

        controller.turnAllOn();
        light.setBrightness(80);
        ac.setTemperature(20);

        System.out.println("\n--- Current Status ---");
        controller.displayAllDevices();

        System.out.println("\nTotal Energy: " + controller.getTotalEnergyUsage() + " kWh");
        
        System.out.println("\nDimming all lights to 20%...");
        controller.dimAllLights(20);
        
        controller.turnAllOff();
        System.out.println("\n=== END OF TEST ===");
    }
}

public class MobilePhone {
    private String brand;
    private String model;
    private double price;
    private int batteryLevel; 

    public MobilePhone() {
        this("Unknown", "Unknown", 0.0);
    }

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = 100; 
        this.isOn = false;     
        setPrice(price);        
    }

    

    public String getBrand() { 
        return brand;
         }
    public String getModel() {
         return model;
          }
    public double getPrice() { 
        return price; 
        }
    public int getBatteryLevel() {
         return batteryLevel;
          }
    public boolean isOn() {
         return isOn; 
         }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price cannot be negative. Update ignored.");
        }
    }

    public void setBatteryLevel(int level) {
        if (level >= 0 && level <= 100) {
            this.batteryLevel = level;
        }
    }

  

    public void turnOn() {
        if (batteryLevel > 0) {
            isOn = true;
            System.out.println("📱 " + brand + " is booting up...");
        } else {
            System.out.println("🪫 Cannot turn on: Battery is empty.");
        }
    }

    public void turnOff() {
        isOn = false;
        System.out.println("💤 Phone is shutting down...");
    }

    public void makeCall(String contact) {
        if (!isOn) {
            System.out.println("❌ Turn the phone on first!");
            return;
        }

        if (batteryLevel >= 5) {
            System.out.println("📞 Calling " + contact + "...");
            batteryLevel -= 5;
        } else {
            System.out.println("🪫 Battery too low to make a call (Minimum 5%).");
        }
    }

    public void chargeBattery(int minutes) {
        int chargeGained = minutes * 2;
        batteryLevel = Math.min(100, batteryLevel + chargeGained);
        System.out.println("🔌 Charged for " + minutes + " mins. Current Battery: " + batteryLevel + "%");
    }


    public void displayInfo() {
        System.out.println("\n============================");
        System.out.println("      PHONE STATUS          ");
        System.out.println("============================");
        System.out.println("Device:  " + brand + " " + model);
        System.out.println("Price:   " + price);
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Status:  " + (isOn ? "Active" : "Idle"));
        System.out.println("============================\n");
    }
}
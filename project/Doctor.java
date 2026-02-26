public class Doctor {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Dr. " + name + " (" + specialty + ")";
    }
}
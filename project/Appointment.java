public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment: " + patient.getName() + " with " + doctor.getName() + " at " + time;
    }
}
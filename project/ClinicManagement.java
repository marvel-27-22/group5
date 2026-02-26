import java.util.ArrayList;
import java.util.Scanner;

public class ClinicManagement {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();
        
        
        doctors.add(new Doctor("Smith", "General Medicine"));
        doctors.add(new Doctor("Jones", "Pediatrics"));

        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Clinic System Menu ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("4. View All Appointments");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Age: "); int a = sc.nextInt(); sc.nextLine();
                System.out.print("Illness: "); String i = sc.nextLine();
                patients.add(new Patient(n, a, i));
                System.out.println("Patient Registered!");

            } else if (choice == 2) {
                for (Doctor d : doctors) System.out.println(d);

            } else if (choice == 5) {
                System.out.println("Closing System...");
                break;
            }
            
        }
    }
}
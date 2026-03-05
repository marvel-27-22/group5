import java.util.ArrayList;
import java.util.Scanner;

public class StudentIDSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        IDCardPrinter printer = new IDCardPrinter();
        Scanner input = new Scanner(System.in);

        students.add(new Student("24/BITA/001", "Your Real Name", "BITA", 1, "01/01/2000", "Male", "Zanzibari", "0771234567", "me@suza.ac.tz", "photo.jpg"));
        students.add(new Student("24/BITA/045", "Juma Ali", "BITA", 1, "05/05/2001", "Male", "Zanzibari", "0770000001", "juma@suza.ac.tz", "juma.jpg"));
        students.add(new Student("24/DIP/012", "Amina Hassan", "DIP", 2, "10/10/1999", "Female", "Tanzanian", "0770000002", "amina@suza.ac.tz", "amina.jpg"));

        while (true) {
            System.out.println("\n--- SUZA Digital ID System ---");
            System.out.println("1. Display all ID cards");
            System.out.println("2. Search by Registration Number");
            System.out.println("3. Search by Name");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            
            int choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1) {
                for (Student s : students) printer.printIDCard(s);
            } else if (choice == 2) {
                System.out.print("Enter Reg Number: ");
                String reg = input.nextLine();
                for (Student s : students) {
                    if (s.getRegistrationNumber().equalsIgnoreCase(reg)) printer.printIDCard(s);
                }
            } else if (choice == 3) {
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                for (Student s : students) {
                    if (s.getFullName().toLowerCase().contains(name.toLowerCase())) printer.printIDCard(s);
                }
            } else if (choice == 4) break;
        }
        input.close();
    }
}
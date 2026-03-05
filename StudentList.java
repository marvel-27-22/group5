import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View List");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Alphabetically");
            System.out.println("6. Edit Student Name");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter name: ");
                students.add(scanner.nextLine());
            } 
            else if (choice == 2) {
                System.out.print("Name to remove: ");
                String name = scanner.nextLine();
                if (students.remove(name)) {
                    System.out.println("Removed.");
                } else {
                    System.out.println("Not found.");
                }
            } 
            else if (choice == 3) {
                System.out.println("List: " + students);
            } 
            else if (choice == 4) {
                System.out.print("Name to find: ");
                String name = scanner.nextLine();
                if (students.contains(name)) {
                    System.out.println("Found at index: " + students.indexOf(name));
                } else {
                    System.out.println("Not found.");
                }
            } 
            else if (choice == 5) {
                Collections.sort(students);
                System.out.println("Sorted!");
            } 
            else if (choice == 6) {
                System.out.print("Current name to edit: ");
                String oldName = scanner.nextLine();
                int index = students.indexOf(oldName);
                if (index != -1) {
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    students.set(index, newName);
                    System.out.println("Updated!");
                } else {
                    System.out.println("Not found.");
                }
            }
        } while (choice != 7);

        scanner.close();
    }
}
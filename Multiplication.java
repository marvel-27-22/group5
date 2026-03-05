import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Full Multiplication Grid ===");
        
        System.out.print("Enter starting number: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter ending number: ");
        int end = scanner.nextInt();

        System.out.print("      ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n----------------------------------------------");

        for (int i = start; i <= end; i++) {
            System.out.printf("%2d | ", i);
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        scanner.close();
    }
}
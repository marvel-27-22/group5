import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter first number (or 0 to quit): ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter operation (+, -, *, /, %, ^) or 'q' to quit: ");
            char op = scanner.next().charAt(0);
            
            if (op == 'q') {
                break;
            }
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            if (op == '+') {
                System.out.println("Result: " + (num1 + num2));
            } else if (op == '-') {
                System.out.println("Result: " + (num1 - num2));
            } else if (op == '*') {
                System.out.println("Result: " + (num1 * num2));
            } else if (op == '/') {
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero");
                }
            } else if (op == '%') {
                System.out.println("Result: " + (num1 % num2));
            } else if (op == '^') {
                System.out.println("Result: " + Math.pow(num1, num2));
            } else {
                System.out.println("Invalid operation");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}

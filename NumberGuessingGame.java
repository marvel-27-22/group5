import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("=== Number Guessing Game ===");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-500)");
            System.out.print("Choose difficulty: ");
            int diff = scanner.nextInt();

            int maxRange = 100;
            int maxAttempts = 10;

            if (diff == 1) {
                maxRange = 50;
                maxAttempts = 5;
            } else if (diff == 3) {
                maxRange = 500;
                maxAttempts = 15;
            }

            int secretNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("I'm thinking of a number between 1 and " + maxRange);
            System.out.println("You have " + maxAttempts + " tries!");

            while (attempts < maxAttempts) {
                System.out.print("Enter guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Correct! You used " + attempts + " tries.");
                    hasWon = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                System.out.println("Tries left: " + (maxAttempts - attempts));
            }

            if (!hasWon) {
                System.out.println("Game Over! The number was " + secretNumber);
            }

            System.out.print("Play again? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice != 'y') {
                playAgain = false;
            }
        }
        
        System.out.println("Goodbye!");
        scanner.close();
    }
}
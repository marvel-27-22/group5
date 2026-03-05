import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many subjects do you have? ");
        int numSubjects = scanner.nextInt();

        double totalScore = 0;
        int count = 0;

        while (count < numSubjects) {
            System.out.print("Enter score for subject " + (count + 1) + ": ");
            double score = scanner.nextDouble();

            if (score >= 0 && score <= 100) {
                totalScore = totalScore + score;
                count = count + 1;
            } else {
                System.out.println("Invalid score! Please enter a value between 0 and 100.");
            }
        }

        double average = totalScore / numSubjects;
        char grade;
        String description;

        if (average >= 90) {
            grade = 'A';
            description = "Excellent";
        } else if (average >= 80) {
            grade = 'B';
            description = "Very Good";
        } else if (average >= 70) {
            grade = 'C';
            description = "Good";
        } else if (average >= 60) {
            grade = 'D';
            description = "Satisfactory";
        } else if (average >= 50) {
            grade = 'E';
            description = "Pass";
        } else {
            grade = 'F';
            description = "Fail";
        }

        System.out.println("\n--- Final Results ---");
        System.out.println("Average Score: " + average);
        System.out.println("Overall Grade: " + grade + " (" + description + ")");

        if (average >= 50) {
            System.out.println("Status: PASSED");
        } else {
            System.out.println("Status: FAILED");
        }

        scanner.close();
    }
}
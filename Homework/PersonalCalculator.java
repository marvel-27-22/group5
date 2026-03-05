
public class PersonalCalculator {
    public static void main(String[] args) {
        
        String regNumber = "BITA/2023/0045"; 
        String fullName = "Zuberi Ali Hassan";
        int birthYear = 2003;
        int currentYear = 2026;

        String lastFourStr = regNumber.substring(regNumber.length() - 4);
        int lastDigits = Integer.parseInt(lastFourStr);

        String nameNoSpaces = fullName.replace(" ", "");
        int nameLetters = nameNoSpaces.length();

        int multiplicationResult = lastDigits * nameLetters;
        int age = currentYear - birthYear;
        int agePlusReg = age + lastDigits;

        System.out.println("================================================");
        System.out.println("PERSONAL CALCULATOR REPORT");
        System.out.println("Student: " + fullName);
        System.out.println("Registration: " + regNumber);
        System.out.println("================================================");
        System.out.println("Last 4 digits of registration: " + lastDigits);
        System.out.println("Letters in my name: " + nameLetters);
        System.out.println("Multiplication result: " + lastDigits + " * " + nameLetters + " = " + multiplicationResult);
        System.out.println("My birth year: " + birthYear);
        System.out.println("My current age: " + age);
        System.out.println("Age + Registration digits: " + age + " + " + lastDigits + " = " + agePlusReg);
        System.out.println("================================================");
    }
}
public class FamilyAgeAnalyzer {
    public static void main(String[] args) {
        String studentName = "Zuberi Ali Hassan";
        String studentReg = "BITA/2023/0045";

        String[] names = {"Zuberi", "Ali", "Fatma", "Khamis", "Mariam"};
        int[] ages = {21, 52, 48, 18, 12};
        String[] relations = {"Self", "Father", "Mother", "Brother", "Sister"};

        int totalMembers = names.length;
        int sum = 0;

        for (int i = 0; i < ages.length; i++) {
            sum = sum + ages[i];
        }

        double average = (double) sum / totalMembers;

        int oldestIndex = 0;
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] > ages[oldestIndex]) {
                oldestIndex = i;
            }
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        int ageGap = ages[oldestIndex] - ages[youngestIndex];

        int aboveCount = 0;
        int belowCount = 0;

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] > average) {
                aboveCount++;
            } else {
                belowCount++;
            }
        }

        System.out.println("================================================");
        System.out.println("FAMILY AGE ANALYSIS REPORT");
        System.out.println("Student: " + studentName + " - " + studentReg);
        System.out.println("================================================");
        System.out.println("Family Members:");

        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - Age: " + ages[i] + " (Relationship: " + relations[i] + ")");
        }

        System.out.println("------------------------------------------------");
        System.out.println("Total family members: " + totalMembers);
        System.out.printf("Average family age: %.2f years%n", average);
        System.out.println("Oldest: " + names[oldestIndex] + " (" + ages[oldestIndex] + " years)");
        System.out.println("Youngest: " + names[youngestIndex] + " (" + ages[youngestIndex] + " years)");
        System.out.println("Age gap: " + ageGap + " years");
        System.out.println("Members above average: " + aboveCount);
        System.out.println("Members below average: " + belowCount);

        if (ages[0] > average) {
            System.out.println("I am ABOVE the family average");
        } else {
            System.out.println("I am BELOW the family average");
        }
        System.out.println("================================================");
    }
}
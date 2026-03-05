public class CourseGradePredictor {
    public static void main(String[] args) {
                String studentName = "JABIR KHATOR";
        String studentReg = "BITA/7/23/058/TZ";
;
        String semester = "Semester 2, 2026";

        String[] courses = {"PT821", "PT822", "GS102", "MT101", "CS105"};
        String[] courseNames = {"OOP", "Data Structures", "Communication", "Math", "Database"};
        double[] courseworkScores = {32.5, 28.0, 35.0, 22.5, 30.0}; 

        int countA = 0;
        int countBPlus = 0;
        int needsAttention = 0;
        String priorityFocus = courses[0];
        double lowestScore = courseworkScores[0];

        System.out.println("================================================");
        System.out.println("SEMESTER GRADE PREDICTION REPORT");
        System.out.println("Student: " + studentName);
        System.out.println("Registration: " + studentReg);
        System.out.println("Semester: " + semester);
        System.out.println("================================================\n");

        for (int i = 0; i < courses.length; i++) {
            double currentMark = courseworkScores[i];
            double courseworkPercent = (currentMark / 40) * 100;

            System.out.println("COURSE: " + courses[i] + " - " + courseNames[i]);
            System.out.println("Current Coursework: " + currentMark + "/40 marks");
            System.out.println("Coursework Percentage: " + courseworkPercent + "%");

            System.out.println("To achieve grade A (70+): Need " + requiredExamScore(currentMark, 70) + "/60");
            System.out.println("To achieve grade B+ (60+): Need " + requiredExamScore(currentMark, 60) + "/60");
            System.out.println("To achieve grade B (50+): Need " + requiredExamScore(currentMark, 50) + "/60");

            String prediction = predictGrade(currentMark);
            System.out.println("Prediction: Likely grade is " + prediction);

            if (currentMark >= 28) {
                System.out.println("Status: SAFE");
                if (prediction.equals("A")) countA++;
                else if (prediction.equals("B+")) countBPlus++;
            } else if (currentMark >= 20) {
                System.out.println("Status: NEEDS IMPROVEMENT");
            } else {
                System.out.println("Status: AT RISK");
                needsAttention++;
            }

            if (currentMark < lowestScore) {
                lowestScore = currentMark;
                priorityFocus = courses[i];
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------");
        System.out.println("OVERALL SEMESTER OUTLOOK:");
        System.out.println("Courses on track for A: " + countA);
        System.out.println("Courses on track for B+: " + countBPlus);
        System.out.println("Courses needing attention: " + (courses.length - countA - countBPlus));
        System.out.println("\nPriority Focus: " + priorityFocus);
        System.out.println("================================================");
    }

    public static double requiredExamScore(double coursework, double targetTotal) {
        double needed = targetTotal - coursework;
        if (needed > 60) return 0.0; // Impossible to reach
        return Math.max(0, needed);
    }

    public static String predictGrade(double coursework) {
        double assumedExam = (coursework / 40) * 60;
        double total = coursework + assumedExam;

        if (total >= 70) return "A";
        else if (total >= 60) return "B+";
        else if (total >= 50) return "B";
        else if (total >= 40) return "C";
        else if (total >= 35) return "D";
        else if (total >= 30) return "E";
        else return "F";
    }
}
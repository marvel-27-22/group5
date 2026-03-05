public class DailyExpenseTracker {
    public static void main(String[] args) {
        String studentName = "Your Name";
        String studentReg = "BITA/202X/XXXX";
        String startDate = "Feb 27, 2026";
        String endDate = "March 5, 2026";

        String[] categories = {"Food", "Transport", "Airtime", "Entertainment", "Stationery", "Other"};
        String[] dates = {"Feb 27", "Feb 28", "Mar 1", "Mar 2", "Mar 3", "Mar 4", "Mar 5"};
        
        double[][] expenses = {
            {5000, 2000, 1000, 0, 1500, 500},
            {4500, 2000, 500, 5000, 0, 0},
            {6000, 1500, 1000, 0, 0, 2000},
            {5500, 2500, 500, 0, 3000, 0},
            {4000, 2000, 2000, 10000, 0, 1000},
            {5000, 2000, 1000, 0, 500, 0},
            {7000, 3000, 500, 0, 0, 500}
        };

        double[] dailyTotals = new double[7];
        double[] categoryTotals = new double[6];
        double grandTotal = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                dailyTotals[i] += expenses[i][j];
                categoryTotals[j] += expenses[i][j];
            }
            grandTotal += dailyTotals[i];
        }

        int highestDayIdx = 0;
        for (int i = 1; i < 7; i++) {
            if (dailyTotals[i] > dailyTotals[highestDayIdx]) {
                highestDayIdx = i;
            }
        }

        int highestCatIdx = 0;
        for (int j = 1; j < 6; j++) {
            if (categoryTotals[j] > categoryTotals[highestCatIdx]) {
                highestCatIdx = j;
            }
        }

        System.out.println("================================================");
        System.out.println("7-DAY EXPENSE REPORT");
        System.out.println("Student: " + studentName + " - " + studentReg);
        System.out.println("Period: " + startDate + " to " + endDate);
        System.out.println("================================================");

        for (int i = 0; i < 7; i++) {
            System.out.println("DAY " + (i + 1) + " - [" + dates[i] + "]:");
            for (int j = 0; j < 6; j++) {
                if (expenses[i][j] > 0) {
                    System.out.println("  " + categories[j] + ": TSh " + expenses[i][j]);
                }
            }
            System.out.println("  Daily Total: TSh " + dailyTotals[i] + "\n");
        }

        System.out.println("------------------------------------------------");
        System.out.println("CATEGORY SUMMARY:");
        for (int j = 0; j < 6; j++) {
            double percent = (categoryTotals[j] / grandTotal) * 100;
            System.out.printf("%-15s: TSh %-10.0f (%.1f%%)%n", categories[j], categoryTotals[j], percent);
        }

        System.out.println("------------------------------------------------");
        System.out.println("TOTAL 7-DAY SPENDING: TSh " + grandTotal);
        System.out.println("Daily Average: TSh " + (grandTotal / 7));
        System.out.println("Highest Day: " + dates[highestDayIdx] + " - TSh " + dailyTotals[highestDayIdx]);
        System.out.println("Highest Category: " + categories[highestCatIdx] + " - TSh " + categoryTotals[highestCatIdx]);
        
        System.out.println("\nADVICE: " + getAdvice(categoryTotals, categories, grandTotal));
        System.out.println("================================================");
    }

    public static String getAdvice(double[] totals, String[] cats, double grand) {
        double foodPercent = (totals[0] / grand) * 100;
        double entPercent = (totals[3] / grand) * 100;

        if (entPercent > 20) {
            return "You are spending too much on Entertainment. Try to save more!";
        } else if (foodPercent > 50) {
            return "Your food expenses are very high. Consider meal prepping.";
        } else {
            return "Your spending looks balanced. Keep it up!";
        }
    }
}
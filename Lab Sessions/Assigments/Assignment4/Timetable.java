import java.util.ArrayList;

public class Timetable {
    private String studentName, regNumber, program;
    private ArrayList<ScheduleItem> schedule = new ArrayList<>();

    public Timetable(String name, String reg, String prog) {
        this.studentName = name;
        this.regNumber = reg;
        this.program = prog;
    }

    public void addItem(ScheduleItem item) { schedule.add(item); }

    public void displayWeeklySchedule() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    WEEKLY TIMETABLE - 2026                       ║");
        System.out.printf("║  Student: %-18s Reg: %-15s Prog: %-8s ║\n", studentName, regNumber, program);
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String day : days) {
            System.out.println(" > " + day.toUpperCase());
            for (ScheduleItem item : schedule) {
                if (item.getDayOfWeek().equalsIgnoreCase(day)) {
                    System.out.printf("   %s-%s | %-7s | %-10s | %s\n", 
                        item.getStartTime(), item.endTime, item.getCourseCode(), item.getItemType(), item.getVenue());
                }
            }
            System.out.println(" ------------------------------------------------------------------");
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }
}
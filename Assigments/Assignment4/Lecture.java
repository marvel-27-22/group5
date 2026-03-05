public class Lecture extends ScheduleItem {
    private int lectureNumber;
    private boolean isCompulsory;

    public Lecture(String code, String name, String inst, String ven, String day, String start, String end, int num, boolean comp) {
        super(code, name, inst, ven, day, start, end);
        this.lectureNumber = num;
        this.isCompulsory = comp;
    }

    @Override public int getDuration() { return 120; } 
    @Override public String getItemType() { return "Lecture"; }
}
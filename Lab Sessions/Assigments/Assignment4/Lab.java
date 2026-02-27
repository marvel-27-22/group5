public class Lab extends ScheduleItem {
    private String requiredSoftware;

    public Lab(String code, String name, String inst, String ven, String day, String start, String end, String sw) {
        super(code, name, inst, ven, day, start, end);
        this.requiredSoftware = sw;
    }

    @Override public int getDuration() { return 180; }
    @Override public String getItemType() { return "Lab"; }
}
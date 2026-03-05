public class Tutorial extends ScheduleItem {
    private String group;

    public Tutorial(String code, String name, String inst, String ven, String day, String start, String end, String gp) {
        super(code, name, inst, ven, day, start, end);
        this.group = gp;
    }

    @Override public int getDuration() { return 60; }
    @Override public String getItemType() { return "Tutorial"; }
}
public class Chanjo extends HudumaAfya implements Ripoti {
    private String ainaYaChanjo;

    public Chanjo(String aina, String tarehe) {
        super(tarehe);
        this.ainaYaChanjo = aina;
    }

    @Override
    public void onyeshaMaelezo() {
        System.out.println("   [✓] Chanjo: " + ainaYaChanjo + " | Tarehe: " + getTarehe());
    }
}
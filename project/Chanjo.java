public class Chanjo {
    private String ainaYaChanjo;
    private String tareheAliyopata;

    public Chanjo(String aina, String tarehe) {
        this.ainaYaChanjo = aina;
        this.tareheAliyopata = tarehe;
    }

    @Override
    public String toString() {
        return "Chanjo: " + ainaYaChanjo + " ilitolewa tarehe: " + tareheAliyopata;
    }
}
import java.util.ArrayList;

public class Mtoto {
    private String nambaYaMtoto;
    private String jinaLaMtoto;
    private double uzitoWaKuzaliwa;
    private ArrayList<Chanjo> orodhaYaChanjo;

    public Mtoto(String namba, String jina, double uzito) {
        this.nambaYaMtoto = namba;
        this.jinaLaMtoto = jina;
        setUzito(uzito); 
        this.orodhaYaChanjo = new ArrayList<>();
    }


    public void setUzito(double uzito) {
        if (uzito > 0) {
            this.uzitoWaKuzaliwa = uzito;
        } else {
            System.out.println("Kosa: Uzito lazima uwe zaidi ya 0. Umewekwa 1.0 kwa muda.");
            this.uzitoWaKuzaliwa = 1.0;
        }
    }

    public void ongezaChanjo(Chanjo c) {
        orodhaYaChanjo.add(c);
    }

    public void onyeshaKadiKamili() {
        System.out.println("\n========= KADI YA RCH 1 =========");
        System.out.println("Namba: " + nambaYaMtoto);
        System.out.println("Mtoto: " + jinaLaMtoto);
        System.out.println("Uzito: " + uzitoWaKuzaliwa + "kg");
        System.out.println("---------------------------------");
        if (orodhaYaChanjo.isEmpty()) {
            System.out.println("Bado hajapata chanjo yoyote.");
        } else {
            for (Chanjo c : orodhaYaChanjo) {
                c.onyeshaMaelezo();
            }
        }
        System.out.println("=================================\n");
    }
}
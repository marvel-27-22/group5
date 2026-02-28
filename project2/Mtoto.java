import java.util.ArrayList;

public class Mtoto {
    private String nambaYaMtoto;
    private String jinaLaMtoto;
    private double uzitoWaKuzaliwa;
    private ArrayList<Chanjo> orodhaYaChanjo; 
   
    public Mtoto(String namba, String jina, double uzito) {
        this.nambaYaMtoto = namba;
        this.jinaLaMtoto = jina;
        this.uzitoWaKuzaliwa = uzito;
        this.orodhaYaChanjo = new ArrayList<>();
    }

    public void ongezaChanjo(Chanjo c) {
        orodhaYaChanjo.add(c);
    }

    public void onyeshaKadiKamili() {
        System.out.println("\n======================================");
        System.out.println("      KADI YA KLINIKI YA MTOTO");
        System.out.println("======================================");
        System.out.println("Na. ya Mtoto: " + nambaYaMtoto);
        System.out.println("Jina: " + jinaLaMtoto);
        System.out.println("Uzito wa Kuzaliwa: " + uzitoWaKuzaliwa + "kg");
        System.out.println("--------------------------------------");
        System.out.println("CHANJO (Aina na Tarehe):");
        
        for (Chanjo c : orodhaYaChanjo) {
            c.onyeshaMaelezo(); 
        }
        System.out.println("======================================\n");
    }
}
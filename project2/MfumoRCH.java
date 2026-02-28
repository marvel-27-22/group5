import java.util.ArrayList;
import java.util.Scanner;

public class MfumoRCH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mtoto> rekodiZaKliniki = new ArrayList<>();
        
        System.out.println("KARIBU KWENYE MFUMO WA KLINIKI (RCH 1)");

        while (true) {
            System.out.println("1. Sajili Mtoto Mpya");
            System.out.println("2. Ongeza Chanjo kwa Mtoto");
            System.out.println("3. Onyesha Kadi ya Mtoto");
            System.out.println("4. Toka");
            System.out.print("Chagua: ");
            int chagua = sc.nextInt();
            sc.nextLine(); // Clear buffer

            if (chagua == 1) {
                System.out.print("Na. ya Mtoto: "); String namba = sc.nextLine();
                System.out.print("Jina la Mtoto: "); String jina = sc.nextLine();
                System.out.print("Uzito (kg): "); double uzito = sc.nextDouble();
                
                rekodiZaKliniki.add(new Mtoto(namba, jina, uzito));
                System.out.println("Usajili Umekamilika!");

            } else if (chagua == 2) {
                if (rekodiZaKliniki.isEmpty()) {
                    System.out.println("Sajili mtoto kwanza!");
                    continue;
                }
                System.out.print("Ingiza Jina la Chanjo (mf. BCG): "); String aina = sc.nextLine();
                System.out.print("Tarehe ya Leo: "); String leo = sc.nextLine();
                
                rekodiZaKliniki.get(rekodiZaKliniki.size() - 1).ongezaChanjo(new Chanjo(aina, leo));
                System.out.println("Chanjo Imeongezwa!");

            } else if (chagua == 3) {
                for (Mtoto m : rekodiZaKliniki) {
                    m.onyeshaKadiKamili();
                }
            } else if (chagua == 4) {
                System.out.println("Asante kwa kutumia Mfumo wa RCH!");
                break;
            }
        }
        sc.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class MfumoWaKliniki {
    public static void main(String[] args) {
        ArrayList<TaarifaYaMtoto> watoto = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Wizara ya Afya na Ustawi wa Jamii ---");
        System.out.println("      MFUMO WA KADI YA KLINIKI");

        while (true) {
            System.out.println("\n1. Sajili Kadi ya Mtoto");
            System.out.println("2. Angalia Orodha ya Watoto");
            System.out.println("3. Toka Kwenye Mfumo");
            System.out.print("Chagua huduma: ");
            
            int chagua = sc.nextInt();
            sc.nextLine(); 

            if (chagua == 1) {
                System.out.print("Na. ya Mtoto: "); String namba = sc.nextLine();
                System.out.print("Jina la Mtoto: "); String jina = sc.nextLine();
                System.out.print("Tarehe ya Kuzaliwa: "); String tarehe = sc.nextLine();
                System.out.print("Uzito wa Kuzaliwa (Kilo): "); double uzito = sc.nextDouble();
                sc.nextLine(); 
                System.out.print("Jina la Mama / Mlezi: "); String mama = sc.nextLine();
                System.out.print("Jina la Baba / Mlezi: "); String baba = sc.nextLine();

                watoto.add(new TaarifaYaMtoto(namba, jina, tarehe, uzito, mama, baba));
                System.out.println("Kadi imesajiliwa kikamilifu!");

            } else if (chagua == 2) {
                System.out.println("\n--- ORODHA YA WATOTO ---");
                for (TaarifaYaMtoto mtoto : watoto) {
                    System.out.println(mtoto);
                }
            } else if (chagua == 3) {
                System.out.println("Asante, mfumo unafungwa.");
                break;
            } else {
                System.out.println("Chaguo si sahihi, jaribu tena.");
            }
        }
    }
}
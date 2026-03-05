import java.util.ArrayList;

public class PhoneContactManager {
    public static void main(String[] args) {
        String ownerName = "Zuberi Ali Hassan";
        String ownerReg = "BITA/2023/0045";
        String myNumber = "0754123456";

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();

        names.add("Zuberi (Self)"); phones.add(myNumber); categories.add("Family");
        names.add("Ali Hassan"); phones.add("0754222333"); categories.add("Family");
        names.add("Fatma Said"); phones.add("0713444555"); categories.add("Family");
        names.add("John Mdoe"); phones.add("0784666777"); categories.add("Friends");
        names.add("Sara Juma"); phones.add("0685888999"); categories.add("Friends");
        names.add("Hamisi Ali"); phones.add("0622111222"); categories.add("Classmates");
        names.add("Neema Paul"); phones.add("0767333444"); categories.add("Classmates");
        names.add("Bakari Musa"); phones.add("0732555666"); categories.add("Others");
        names.add("Anna Shayo"); phones.add("0654777888"); categories.add("Others");
        names.add("Iddi Juma"); phones.add("0679111333"); categories.add("Classmates");

        System.out.println("================================================");
        System.out.println("MY PHONE CONTACTS ANALYSIS");
        System.out.println("Owner: " + ownerName + " - " + ownerReg);
        System.out.println("My Number: " + myNumber + " (" + getProvider(myNumber) + ")");
        System.out.println("================================================");

        String[] cats = {"Family", "Friends", "Classmates", "Others"};
        for (String c : cats) {
            int count = 0;
            System.out.println("\n" + c.toUpperCase() + " CONTACTS:");
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).equals(c)) {
                    System.out.println("- " + names.get(i) + ": " + phones.get(i) + " (" + getProvider(phones.get(i)) + ")");
                    count++;
                }
            }
            System.out.println("Total " + c + ": " + count);
        }

        int voda = 0, airtel = 0, tigo = 0, halo = 0, ttcl = 0;
        for (String p : phones) {
            String prov = getProvider(p);
            if (prov.equals("Vodacom")) voda++;
            else if (prov.equals("Airtel")) airtel++;
            else if (prov.equals("Tigo")) tigo++;
            else if (prov.equals("Halotel")) halo++;
            else if (prov.equals("TTCL")) ttcl++;
        }

        System.out.println("\n------------------------------------------------");
        System.out.println("NETWORK ANALYSIS:");
        System.out.println("Vodacom contacts: " + voda);
        System.out.println("Airtel contacts: " + airtel);
        System.out.println("Tigo contacts: " + tigo);
        System.out.println("Halotel contacts: " + halo);
        System.out.println("TTCL contacts: " + ttcl);

        String mostUsed = "Vodacom";
        int max = voda;
        if (airtel > max) { mostUsed = "Airtel"; max = airtel; }
        if (tigo > max) { mostUsed = "Tigo"; max = tigo; }
        if (halo > max) { mostUsed = "Halotel"; max = halo; }
        if (ttcl > max) { mostUsed = "TTCL"; max = ttcl; }

        System.out.println("\nMost used network: " + mostUsed + " (" + max + " contacts)");
        System.out.println("================================================");
    }

    public static String getProvider(String phone) {
        if (phone.startsWith("074") || phone.startsWith("075") || phone.startsWith("076")) return "Vodacom";
        if (phone.startsWith("078") || phone.startsWith("079") || phone.startsWith("068") || phone.startsWith("069")) return "Airtel";
        if (phone.startsWith("071") || phone.startsWith("065") || phone.startsWith("067")) return "Tigo";
        if (phone.startsWith("062")) return "Halotel";
        if (phone.startsWith("073")) return "TTCL";
        return "Unknown";
    }
}
public class MfumoRCH {
    public static void main(String[] args) {
        // 1. Kutengeneza Object ya Mtoto kwa kutumia Constructor
        Mtoto mtoto = new Mtoto("964/011", "SAIDI MAKAME HAJI", 2.7);

        // 2. Kutengeneza Objects za Chanjo (Inheritance)
        Chanjo c1 = new Chanjo("BCG", "26/7/2010");
        Chanjo c2 = new Chanjo("Polio (Mwezi 1)", "26/8/2010");
        Chanjo c3 = new Chanjo("Polio (Mwezi 2)", "27/9/2010");

        // 3. Kuongeza chanjo kwenye kadi ya mtoto
        mtoto.ongezaChanjo(c1);
        mtoto.ongezaChanjo(c2);
        mtoto.ongezaChanjo(c3);

        // 4. Kuonyesha ripoti ya kadi
        mtoto.onyeshaKadiKamili();
    }
}
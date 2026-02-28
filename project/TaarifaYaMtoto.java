public class TaarifaYaMtoto {
    private String nambaYaMtoto;
    private String jinaLaMtoto;
    private String tareheYaKuzaliwa;
    private double uzitoWaKuzaliwa;
    private String jinaLaMama;
    private String jinaLaBaba;

    public TaarifaYaMtoto(String namba, String jina, String tarehe, double uzito, String mama, String baba) {
        this.nambaYaMtoto = namba;
        this.jinaLaMtoto = jina;
        this.tareheYaKuzaliwa = tarehe;
        this.uzitoWaKuzaliwa = uzito;
        this.jinaLaMama = mama;
        this.jinaLaBaba = baba;
    }

    public String getJina() { return jinaLaMtoto; }

    @Override
    public String toString() {
        return "Namba: " + nambaYaMtoto + " | Mtoto: " + jinaLaMtoto + 
               " | Kuzaliwa: " + tareheYaKuzaliwa + " | Uzito: " + uzitoWaKuzaliwa + "kg";
    }
}
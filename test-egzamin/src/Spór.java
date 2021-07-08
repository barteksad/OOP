public class Spór {
    
    
    private Obywatel oskarżyciel;
    private Obywatel oskarżony;
    private int kwota;
    private Werdykt werdykt; // oceniany ze strony oskarżającego
    
    public Werdykt getWerdykt() {
        return werdykt;
    }

    public void setWerdykt(Werdykt werdykt) {
        this.werdykt = werdykt;
    }

    public Obywatel getOskarżyciel() {
        return oskarżyciel;
    }

    public Obywatel getOskarżony() {
        return oskarżony;
    }

    public int getKwota() {
        return kwota;
    }


    public Spór(Obywatel oskarżyciel, Obywatel oskarżony, int kwota) {
        this.oskarżyciel = oskarżyciel;
        this.oskarżony = oskarżony;
        this.kwota = kwota;
    }
}

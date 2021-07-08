package przesyłalne;

import składniki.Składnik;

public class WyślijOceneIOpis extends Przesyłka {
    
    private float ocena;
    private Składnik składnik;
    private String opis_czynności;
    private int ile;
    
    public WyślijOceneIOpis(int adres_nadawcy,float ocena, Składnik składnik, String opis_czynności, int ile) {
        super(adres_nadawcy);
        this.ocena = ocena;
        this.składnik = składnik;
        this.opis_czynności = opis_czynności;
        this.ile = ile;
    }

    public Składnik getSkładnik() {
        return składnik;
    }

    public String getCzynność() {
        return opis_czynności;
    }

    public int getIlość() {
        return ile;
    }

    public float getOcena() {
        return ocena;
    }
}

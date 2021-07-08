package przesyłalne;

import składniki.Składnik;

public class DajSkładniki extends Przesyłka {
    
    private Składnik składnik;
    private int ile;
    
    public DajSkładniki(int adres_nadawcy, Składnik składnik, int ile) {
        super(adres_nadawcy);
        this.składnik = składnik;
        this.ile = ile;
    }
    
    public int getIle() {
        return ile;
    }
    
    public Składnik getSkładnik() {
        return składnik;
    }
}

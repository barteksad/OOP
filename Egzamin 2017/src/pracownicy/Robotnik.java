package pracownicy;

import java.util.Random;

import przesyłalne.DajSkładniki;
import przesyłalne.KoniecPracy;
import przesyłalne.PolecenieModyfikacji;
import przesyłalne.Przesyłka;
import przesyłalne.WyślijOceneIOpis;
import składniki.Składnik;


public class Robotnik extends Pracownik {

    private String opis_czynności;
    private Składnik składnik;
    private int ile;
    private int adres_dyrektora;
    private int adres_kierownik_lini;
    private int adres_magazyniera;
    
    @Override
    public void wyślij(int adres, Przesyłka przesyłka) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Przesyłka czekajOdbierz() {
        // TODO Auto-generated method stub
        return null;
    }

    private float oceń() {
        return (float) 0.5;
    }

    @Override
    public void pracuj() {
        Przesyłka przesyłka;

        wyślij(adres_magazyniera, new DajSkładniki(adres, składnik, ile));
        przesyłka = czekajOdbierz();
        if(przesyłka.getClass().isInstance(KoniecPracy.class))
            return;

        float ocena = oceń();

        wyślij(adres_kierownik_lini, new WyślijOceneIOpis(adres, ocena, składnik, opis_czynności, ile));
        
        przesyłka = czekajOdbierz();
        if(przesyłka.getClass().isInstance(PolecenieModyfikacji.class))
            modyfikuj();
        if(przesyłka.getClass().isInstance(KoniecPracy.class))
            return;
    
    }

    private void modyfikuj() {
        ile = (new Random()).nextInt(10) * (int) Math.round(1.0 / (oceń() + Float.MIN_NORMAL));
    }        
    
}

package pracownicy;

import przesyłalne.DajSkładniki;
import przesyłalne.KoniecPracy;
import przesyłalne.Przesyłka;

public class Magazynier extends Pracownik {

    @Override
    public void wyślij(int adres, Przesyłka przesyłka) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Przesyłka czekajOdbierz() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void pracuj() {
        Przesyłka przesyłka;
        while(! (przesyłka = czekajOdbierz()).getClass().isInstance(KoniecPracy.class)) {
            if(przesyłka.getClass().isInstance(DajSkładniki.class)) {
                DajSkładniki m_przesyłka = (DajSkładniki) przesyłka;
                wyślij(przesyłka.getAdresNadawcy(), new DajSkładniki(adres, m_przesyłka.getSkładnik(), m_przesyłka.getIle()));
            }
        }
    }
    
}

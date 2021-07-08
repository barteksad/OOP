package Kolekcjonerzy;

import java.util.ArrayList;

import Warunki.Warunek;
import ciągi.Ciąg;

abstract public class WieloWarunkowy extends Kolekcjoner {
    
    private ArrayList<Warunek> warunki;
    private boolean poz_neg;
    
    public WieloWarunkowy(ArrayList<Warunek> warunki, boolean poz_neg) {
        this.warunki = warunki;
        this.poz_neg = poz_neg;
    }

    @Override
    public boolean czyPasuje(Ciąg<?> ciąg) {
        for(Warunek warunek : warunki)
            if(!((warunek.sprawdź(ciąg) && poz_neg) || (!warunek.sprawdź(ciąg)  && !poz_neg)))
                return false;
        return true;    
    }
}

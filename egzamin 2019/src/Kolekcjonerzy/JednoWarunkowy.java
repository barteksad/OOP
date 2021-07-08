package Kolekcjonerzy;

import Warunki.Warunek;
import ciągi.Ciąg;

abstract public class JednoWarunkowy extends Kolekcjoner {

    private Warunek warunek;
    
    public JednoWarunkowy(Warunek warunek) {
        this.warunek = warunek;
    }

    @Override
    public boolean czyPasuje(Ciąg<?> ciąg) {
        return warunek.sprawdź(ciąg);
    }
}

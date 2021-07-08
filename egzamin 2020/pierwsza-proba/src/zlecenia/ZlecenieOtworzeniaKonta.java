package zlecenia;

import java.util.Collection;
import java.util.Map;

import konta.Konto;
import wyjątki.WyjątekBanku;

public class ZlecenieOtworzeniaKonta extends Zlecenie{
    
    private Map<String, Integer> dane;
    
    public ZlecenieOtworzeniaKonta(Map<String, Integer> dane) {
        this.dane = dane;
    }

    @Override
    public void wykonaj(Collection<Konto> konta) throws WyjątekBanku {
        // ...
    }
    
}

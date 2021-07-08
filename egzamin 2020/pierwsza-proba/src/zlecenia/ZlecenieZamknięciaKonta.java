package zlecenia;

import java.util.Collection;

import konta.Konto;
import wyjątki.WyjątekBanku;

public class ZlecenieZamknięciaKonta extends Zlecenie {
    
    private Konto konto;
    
    public ZlecenieZamknięciaKonta(Konto konto) {
        this.konto = konto;
    }

    @Override
    void wykonaj(Collection<Konto> konta) throws WyjątekBanku {
        konta.remove(konto);
    }

    
}

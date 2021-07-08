package zlecenia;

import java.util.Collection;

import konta.Konto;
import wyjątki.WyjątekBanku;

public class ZlecenieWpłaty extends Zlecenie {
    
    private Konto konto;
    private String waluta;
    private int kwota;
    
    public ZlecenieWpłaty(Konto konto, String waluta, int kwota) {
        this.konto = konto;
        this.waluta = waluta;
        this.kwota = kwota;
    }

    @Override
    public void wykonaj(Collection<Konto> konta) throws WyjątekBanku {
        konto.wpłać(kwota, waluta);
    }
}

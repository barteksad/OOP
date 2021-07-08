package zlecenia;

import java.util.Collection;

import konta.Konto;
import wyjątki.WyjątekBanku;

public class ZleceniePrzelewu extends Zlecenie {
    
    
    private Konto adresat;
    private Konto nadawca;
    private String waluta;
    private int kwota;
    
    public ZleceniePrzelewu(Konto adresat, Konto nadawca, String waluta, int kwota) {
        this.adresat = adresat;
        this.nadawca = nadawca;
        this.waluta = waluta;
        this.kwota = kwota;
    }

    @Override
    public void wykonaj(Collection<Konto> konta) throws WyjątekBanku {
        int saldo_przed_operacją = nadawca.saldo();

        nadawca.wypłać(kwota, waluta);
        try {
            adresat.wpłać(kwota, waluta);
        } catch (WyjątekBanku b) {
            adresat.ustaw_saldo(saldo_przed_operacją);
            throw b;
        }
    }
}

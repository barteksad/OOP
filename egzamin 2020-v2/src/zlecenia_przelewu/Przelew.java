package zlecenia_przelewu;

import konta.Konto;
import wyjątki.NiepowodzenieWykonania;

public class Przelew extends ZleceniePrzelewu {

    public Przelew(String nadawca, String odbiorca, String waluta, int kwota) {
        super(nadawca, odbiorca, waluta, kwota);
    }

    @Override
    public void wykonaj(Konto nadawca, Konto odbiorca) throws NiepowodzenieWykonania {
        nadawca.wypłać((getKwota()));
        odbiorca.wypłać((getKwota()));
    }
    
}

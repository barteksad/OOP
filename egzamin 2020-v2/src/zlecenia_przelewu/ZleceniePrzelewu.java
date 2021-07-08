package zlecenia_przelewu;

import konta.Konto;
import wyjątki.NiepowodzenieWykonania;

abstract public class ZleceniePrzelewu {

    private String nadawca;
    private String odbiorca;
    private String waluta;
    private int kwota;

    public ZleceniePrzelewu(String nadawca, String odbiorca, String waluta, int kwota) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.waluta = waluta;
        this.kwota = kwota;
    }

    public String getNadawca() {
        return nadawca;
    }

    public String getOdbiorca() {
        return odbiorca;
    }

    public String getWaluta() {
        return waluta;
    }

    public int getKwota() {
        return kwota;
    }

    public abstract void wykonaj(Konto nadawca, Konto odbiorca) throws NiepowodzenieWykonania;
}

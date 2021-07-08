import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import konta.Konto;
import wyjątki.Awaria;
import wyjątki.NiepowodzenieWykonania;
import zlecenia_przelewu.ZleceniePrzelewu;

public class Bank {

    private Map<String, Obywatel> obywatele;
    private ArrayList<Konto> konta;

    public void utworzKonto(String obywatel, String typ, String waluta) {

    }

    public void przetworzZleceniaPrzelewu(Collection<ZleceniePrzelewu> zlecenia) {

        ArrayList<ZleceniePrzelewu> awarie = new ArrayList<ZleceniePrzelewu>();
        ArrayList<ZleceniePrzelewu> niepowodzenia = new ArrayList<ZleceniePrzelewu>();

        for(ZleceniePrzelewu zlecenie : zlecenia) {
            Konto nadawca, odbiorca;

            try {
                nadawca = zlecenie.getNadawca() != null ? znajdźKonto(zlecenie.getNadawca(), zlecenie.getWaluta()) : null;
                odbiorca = zlecenie.getOdbiorca() != null ? znajdźKonto(zlecenie.getOdbiorca(), zlecenie.getWaluta()) : null;
            } catch (Awaria a) {
                awarie.add(zlecenie);
                continue;
            }
            
            int stan_nadawcy_przed = nadawca != null ? nadawca.getStan() : 0;
            int stan_odbiorcy_przed = odbiorca != null ? odbiorca.getStan() : 0;

            try {
                zlecenie.wykonaj(nadawca, odbiorca);
            } catch (NiepowodzenieWykonania nw) {
                if(nadawca != null)
                    nadawca.setStan(stan_nadawcy_przed);
                if(odbiorca != null)
                    odbiorca.setStan(stan_odbiorcy_przed);
                niepowodzenia.add(zlecenie);
                continue;
            }
        }
    }

    public void koniecMiesiaca() {

    }

    private Konto znajdźKonto(String numer, String waluta) throws Awaria {
        Konto znalezione = null;
        for(Konto k : konta)
            if(k.getNumer().equals(numer)) {
                znalezione = k;
                break;
            }
    
        if(znalezione == null)
            throw new Awaria();
        
        znalezione = znalezione.dajWWalucie(waluta);
        if(znalezione == null)
            throw new Awaria();
        else
            return znalezione;
    }
}
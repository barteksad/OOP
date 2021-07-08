package konta;

import java.util.HashMap;
import java.util.Map;

import wyjątki.NiedozwolonaOperacja;
import wyjątki.WyjątekBanku;

public class Zagregowane extends Konto {
    
    private Map<String, Konto> konta;

    public Zagregowane() {
        konta = new HashMap<String, Konto>();
    }

    public void dodajKonot(Konto k) throws WyjątekBanku {
        if (konta.containsKey(k.waluta()))
            throw new NiedozwolonaOperacja();
        else
            konta.put(k.waluta(), k);
    }

    @Override 
    public void wypłać(int kwota, String waluta) throws WyjątekBanku {
        if(!konta.containsKey(waluta))
            throw new NiedozwolonaOperacja();
        else
            konta.get(waluta).wypłać(kwota, waluta);
    }

    @Override 
    public void wpłać(int kwota, String waluta) throws WyjątekBanku {
        if(!konta.containsKey(waluta))
            throw new NiedozwolonaOperacja();
        else
            konta.get(waluta).wpłać(kwota, waluta);    
    }

    @Override
    public void koniecMiesiaca() throws WyjątekBanku {
        for(Konto k: konta.values())
            k.koniecMiesiaca();
    }
}

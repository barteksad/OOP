package konta;

import wyjątki.NiedozwolonaOperacja;
import wyjątki.WyjątekBanku;

public class Oszczędnościowe extends KontoFinansowe {

    private double roczna_stopa;

    public Oszczędnościowe(int saldo, String waluta, String numer, double roczna_stopa) {
        super(saldo, waluta, numer);
        this.roczna_stopa = roczna_stopa;
    }

    @Override 
    public void wypłać(int kwota, String waluta) throws WyjątekBanku {
        throw new NiedozwolonaOperacja();
    }

    @Override
    public void koniecMiesiaca() throws WyjątekBanku {
        double odsetki = (double) saldo * 1.0/12.0 * roczna_stopa;
        this.saldo += (int) odsetki;
    }
    
}

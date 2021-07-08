package konta;

import wyjątki.*;

public class Kartowe extends KontoKredytowe {

    private int limit_kredytowy;

    protected Kartowe(int saldo, String waluta, String numer, Bierzące bierzące, int limit_kredytowy) {
        super(saldo, waluta, numer, bierzące);
        this.limit_kredytowy = limit_kredytowy;
    }
    
    @Override 
    public void wypłać(int kwota, String waluta) throws WyjątekBanku {
        if(kwota > limit_kredytowy)
            throw new NiedozwolonaOperacja();
        else
            this.wpłać(kwota, waluta);
    }

    @Override 
    public void wpłać(int kwota, String waluta) throws WyjątekBanku {
        throw new NiedozwolonaOperacja();
    }

    @Override
    public void koniecMiesiaca() throws WyjątekBanku {
        this.bierzące.wypłać(saldo, this.waluta);
        saldo = 0;
    }
}

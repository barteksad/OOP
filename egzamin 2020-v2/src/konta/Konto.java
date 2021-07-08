package konta;

import wyjątki.NiepowodzenieWykonania;

abstract public class Konto {
    private String numer;
    private String waluta;
    private int stan;


    public Konto(String numer, String waluta, int stan) {
        this.numer = numer;
        this.waluta = waluta;
        this.stan = stan;
    }

    public String getNumer() {
        return numer;
    }

    public String getWaluta() {
        return waluta;
    } 

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public void wpłać(int ile) throws NiepowodzenieWykonania {
        stan += ile;
    }

    public void wypłać(int ile) throws NiepowodzenieWykonania {
        if(stan < ile)
            throw new NiepowodzenieWykonania();
        stan -= ile;
    }

    public Konto dajWWalucie(String waluta) {
        if(this.waluta.equals(waluta))
            return this;
        else
            return null;
    }

    abstract public void koniecMiesiaca() throws NiepowodzenieWykonania;

    abstract public int zamknij() throws NiepowodzenieWykonania;
}

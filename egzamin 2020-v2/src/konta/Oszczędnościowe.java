package konta;

import wyjątki.NiepowodzenieWykonania;

public class Oszczędnościowe extends Finansowe {

    private double roczna_stopa;

    public Oszczędnościowe(String numer, String waluta, int stan, double roczna_stopa) {
        super(numer, waluta, stan);
        this.roczna_stopa = roczna_stopa;
    }

    @Override
    public void koniecMiesiaca() throws NiepowodzenieWykonania {
        int odsetki = (int) (getStan() * 1.0/12.0 * roczna_stopa);
        wpłać(odsetki);
    }

    @Override 
    public void wypłać(int ile) throws NiepowodzenieWykonania {
        throw new NiepowodzenieWykonania();
    }

    @Override
    public int zamknij() throws NiepowodzenieWykonania {
        return getStan();
    }
    
}

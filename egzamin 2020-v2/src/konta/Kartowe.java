package konta;

import wyjątki.NiepowodzenieWykonania;

public class Kartowe extends Kredytowe {

    private int limit_kredytowy;

    public Kartowe(String numer, String waluta, int stan, Bieżące stowarzyszone, int limit_kredytowy) {
        super(numer, waluta, stan, stowarzyszone);
        this.limit_kredytowy = limit_kredytowy;
    }

    @Override
    public void koniecMiesiaca() throws NiepowodzenieWykonania {
        stowarzyszone.wypłać(Math.max(0, -getStan()));
    }

    @Override
    public void wypłać(int ile) throws NiepowodzenieWykonania {
        if(getStan() - ile < -limit_kredytowy)
            throw new NiepowodzenieWykonania();
        setStan(getStan() - ile);
    }

    @Override
    public int zamknij() throws NiepowodzenieWykonania {
        return 0;
    }
    
}

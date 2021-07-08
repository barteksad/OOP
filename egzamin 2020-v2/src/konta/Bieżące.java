package konta;

import wyjątki.NiepowodzenieWykonania;

public class Bieżące extends Finansowe {

    public Bieżące(String numer, String waluta, int stan) {
        super(numer, waluta, stan);
    }

    @Override
    public void koniecMiesiaca() throws NiepowodzenieWykonania {
        return;        
    }

    @Override
    public int zamknij() throws NiepowodzenieWykonania {
        return getStan();
    }
    
}

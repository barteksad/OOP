package konta;

import wyjątki.NiepowodzenieWykonania;

public class Ratalne extends Kredytowe {

    private int rata_kapitałowa;
    private double oprocentowanie;

    public Ratalne(String numer, String waluta, int stan, Bieżące stowarzyszone, int liczba_rat,
            double oprocentowanie) {
        super(numer, waluta, stan, stowarzyszone);
        this.rata_kapitałowa = (int) stan / liczba_rat;
        this.oprocentowanie = oprocentowanie;
    }

    
    @Override
    public void koniecMiesiaca() throws NiepowodzenieWykonania {
        int rata_odsetkowa = (int) (getStan() / 12.0); 
        super.wypłać(rata_kapitałowa);
        stowarzyszone.wypłać(rata_kapitałowa + rata_odsetkowa);
    }
    
    @Override
    public int zamknij() throws NiepowodzenieWykonania {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public void wpłać(int ile) throws NiepowodzenieWykonania {
        throw new NiepowodzenieWykonania();
    }

    @Override
    public void wypłać(int ile) throws NiepowodzenieWykonania {
        throw new NiepowodzenieWykonania();
    }
}

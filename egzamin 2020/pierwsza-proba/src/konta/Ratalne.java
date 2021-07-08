package konta;

import wyjątki.*;

public class Ratalne extends KontoKredytowe {

    private int początkowa_kwota;
    private int liczba_rat;
    private int roczne_oprocentowanie;

    protected Ratalne(int saldo, String waluta, String numer, Bierzące bierzące, int początkowa_kwota, int liczba_rat, int roczne_oprocentowanie) {
        super(saldo, waluta, numer, bierzące);
        this.początkowa_kwota = początkowa_kwota;
        this.liczba_rat = liczba_rat;
        this.roczne_oprocentowanie = roczne_oprocentowanie; 
    }
    
    @Override 
    public void wypłać(int kwota, String waluta) throws WyjątekBanku {
        throw new NiedozwolonaOperacja();
    }

    @Override 
    public void wpłać(int kwota, String waluta) throws WyjątekBanku {
        throw new NiedozwolonaOperacja();
    }

    @Override
    public void koniecMiesiaca() throws WyjątekBanku {
        int rata_kapitałowa = początkowa_kwota / liczba_rat;
        int rata_odsetkowa = (int) ((początkowa_kwota - saldo) * roczne_oprocentowanie * 1.0/12.0);
        int rata = rata_kapitałowa + rata_odsetkowa;

        this.bierzące.wypłać(rata, this.waluta);
        this.saldo += rata;
    }
}

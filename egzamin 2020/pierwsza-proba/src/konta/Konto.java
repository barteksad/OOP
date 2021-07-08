package konta;

import wyjątki.*;

abstract public class Konto {

    protected int saldo;
    protected String waluta;
    protected String numer;

    public Konto() {
        ;
    }

    public Konto (int saldo, String waluta, String numer) {
        this.saldo = saldo;
        this.waluta = waluta;
        this.numer = numer;
    }

    public void wpłać(int kwota, String waluta) throws WyjątekBanku {
        if(this.waluta != waluta)
            throw new ZłaWaluta();
        saldo += kwota;
    }

    public void wypłać(int kwota, String waluta) throws WyjątekBanku {
        if(this.waluta != waluta)
            throw new ZłaWaluta();
        if(saldo < kwota)
            throw new BrakŚrodków();
        saldo -= kwota;
    }

    public void koniecMiesiaca() throws WyjątekBanku {}

    public String numer() {
        return numer;
    }

    public String waluta() {
        return waluta;
    }

    public int saldo() {
        return saldo;
    }

    public void ustaw_saldo(int saldo) {
        this.saldo = saldo;
    }
}

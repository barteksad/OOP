package konta;

abstract public class KontoKredytowe extends Konto {
    protected Bierzące bierzące;

    protected KontoKredytowe(int saldo, String waluta, String numer, Bierzące bierzące) {
        super(saldo, waluta, numer);
        this.bierzące = bierzące;
    }
}

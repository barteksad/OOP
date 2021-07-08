package konta;

public class Bierzące extends KontoKredytowe {

    protected Bierzące(int saldo, String waluta, String numer, Bierzące bierzące) {
        super(saldo, waluta, numer, bierzące);
    }
}

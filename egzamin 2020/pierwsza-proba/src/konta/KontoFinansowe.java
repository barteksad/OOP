package konta;

abstract public class KontoFinansowe extends Konto {

    public KontoFinansowe(int saldo, String waluta, String numer) {
        super(saldo, waluta, numer);
    }
    
}

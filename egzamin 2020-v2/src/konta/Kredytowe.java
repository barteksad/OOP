package konta;

abstract public class Kredytowe extends Konto {

    protected Bieżące stowarzyszone;

    public Kredytowe(String numer, String waluta, int stan, Bieżące stowarzyszone) {
        super(numer, waluta, stan);
        this.stowarzyszone = stowarzyszone;
    }   
    
}

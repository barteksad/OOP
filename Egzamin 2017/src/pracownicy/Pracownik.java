package pracownicy;
import przesyłalne.*;

abstract public class Pracownik implements Terminal<Przesyłka> {
    
    protected int adres;

    public Pracownik() {
        adres = 123; // generowanie unikatowych adresów przez fabrykę i ich ustawienie
    }

    abstract public void pracuj();

}

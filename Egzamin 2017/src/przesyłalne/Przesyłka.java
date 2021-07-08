package przesyłalne;

abstract public class Przesyłka {
    protected int adres_nadawcy;

    public Przesyłka(int adres_nadawcy) {
        this.adres_nadawcy = adres_nadawcy;
    }

    public int getAdresNadawcy() {
        return adres_nadawcy;
    }
}

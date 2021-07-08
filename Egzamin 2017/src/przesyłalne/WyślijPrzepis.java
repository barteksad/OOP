package przesyłalne;

public class WyślijPrzepis extends Przesyłka{

    public WyślijPrzepis(int adres_nadawcy, PrzepisNaBajaderke przepis) {
        super(adres_nadawcy);
        this.przepis = przepis;
    }


    public PrzepisNaBajaderke getPrzepis() {
        return przepis;
    }

    private PrzepisNaBajaderke przepis;
}

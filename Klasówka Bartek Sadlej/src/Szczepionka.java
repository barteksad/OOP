public abstract class Szczepionka 
{
    private String nazwa;
    private String nazwa_producenta;
    private int wielkość_dawki;

    public Szczepionka(String nazwa, String nazwa_producenta, int wielkość_dawki)
    {
        this.nazwa = nazwa;
        this.nazwa_producenta = nazwa_producenta;
        this.wielkość_dawki = wielkość_dawki;
    }

    public static boolean czy_ta_sama(Szczepionka p, Szczepionka l)
    {
        if(p.nazwa != l.nazwa)
            return false;
        if(p.nazwa_producenta != l.nazwa_producenta)
            return false;
        if(p.wielkość_dawki != l.wielkość_dawki)
            return false;
        return true;
    }
}

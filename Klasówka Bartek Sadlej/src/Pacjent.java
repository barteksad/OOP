public class Pacjent 
{
    private int adres;
    private Szczepionka szczepionka;
    private int maksymalna_odległość;
    private int umuwiony_termin;

    public Pacjent(int adres, Szczepionka szczepionka, int maksymalna_odległość)
    {
        this.adres = adres;
        this.szczepionka = szczepionka;
        this.maksymalna_odległość = maksymalna_odległość;
        umuwiony_termin = -1;
    }

    public int adres()
    {
        return adres;
    }

    public Szczepionka szczepionka()
    {
        return szczepionka;
    }

    public int maksymalna_odległość()
    {
        return maksymalna_odległość;
    }

    public boolean czy_pasuje_punkt_szczepień(PunktSzczepeiń punkt_szczepień)
    {
        if(!Szczepionka.czy_ta_sama(szczepionka, punkt_szczepień.szczepionka()))
            return false;
        if(Region.Odległość(adres, punkt_szczepień.adres()) > maksymalna_odległość)
            return false;
        return true;
    }

    public void zapisz_termin(int termin)
    {
        umuwiony_termin = termin;
    }

    public int na_kiedy_umuwiony()
    {
        return umuwiony_termin;
    }
}

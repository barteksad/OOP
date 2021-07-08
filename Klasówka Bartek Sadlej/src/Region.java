import java.util.ArrayList;

public abstract class Region 
{
    private ArrayList<PunktSzczepeiń> punkty_szczepień;

    public Region(ArrayList<PunktSzczepeiń> punkty_szczepień)
    {
        this.punkty_szczepień = punkty_szczepień;
    }

    abstract boolean czy_w_tym_regionie(Pacjent p);

    public PunktSzczepeiń znajdź_najlepszy_punkt(Pacjent p)
    {
        PunktSzczepeiń najciekawszy = null;

        for(PunktSzczepeiń punkt_szczepień: punkty_szczepień)
        {
            if(p.czy_pasuje_punkt_szczepień(punkt_szczepień))
            {
                if(najciekawszy == null)
                    najciekawszy = punkt_szczepień;
                else
                    if(najciekawszy.najbliższy_wolny_termin() > punkt_szczepień.najbliższy_wolny_termin())
                        najciekawszy = punkt_szczepień;
            }
        }
        return najciekawszy;
    }

    public static int Odległość(int adres1, int adres2)
    {
        int odległość = adres1 - adres2;

        return Math.abs(odległość);
    }

    public int ile_zaszczepionych()
    {
        int ile = 0;
        for(PunktSzczepeiń p: punkty_szczepień)
            ile += p.ile_zaszczepionych();
        return ile;
    }
}

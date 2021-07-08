import java.util.ArrayList;

public class CentralneBiuroSzczepeiń
{
    private ArrayList<Region> regiony;
    int ile_zaszczepionych;

    public CentralneBiuroSzczepeiń(ArrayList<Region> regiony)
    {
        this.regiony = regiony;
        ile_zaszczepionych = 0;
    }

    public void zapiszPacjętaDoOptymalnegoPunktu(Pacjent pacjent)
    {
        Region region_pacjęta = null;

        for(Region r: regiony)
            if(r.czy_w_tym_regionie(pacjent))
            {
                region_pacjęta = r;
                break;
            }
        
        PunktSzczepeiń najlepszy_punkt = region_pacjęta.znajdź_najlepszy_punkt(pacjent);
        int termin = najlepszy_punkt.zarejestruj_na_najbliższy_wolny();
        pacjent.zapisz_termin(termin);
        ile_zaszczepionych++;
    }

    public int ile_zaszczepionych()
    {
        return ile_zaszczepionych;
    }
}
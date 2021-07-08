import java.util.ArrayList;
import java.util.LinkedList;

public class Statek 
{
    private int dukaty;
    private int pojemność_ładowni;
    private LinkedList<Jabłko> jabłka;
    private ArrayList<Integer> plan;

    public Statek(int pojemność_ładowni)
    {
        this.pojemność_ładowni = pojemność_ładowni;
    }

    public void zacznij_nowy_tydzień(ArrayList<Integer> plan)
    {
        dukaty = 1000;
        jabłka = new LinkedList<Jabłko>();
        this.plan = plan;
    }
    
    public void symuluj_dzień(int numer_dnia, Archipelag archipelag)
    {
        if(numer_dnia >= plan.size() || jabłka.size() == pojemność_ładowni)
            return;
        Wyspa odwiedzana = archipelag.daj_wyspe(plan.get(numer_dnia));
        Jabłko nowe = odwiedzana.daj_najdroższe_do(dukaty);
        if(nowe != null)
        {
            dukaty -= nowe.koszt();
            jabłka.add(nowe);
        }
    }

    public int ile_łącznie_pestek()
    {
        int ile = 0;
        for(Jabłko j: jabłka)
            ile += j.liczba_pestek();
        return ile;
    }
}



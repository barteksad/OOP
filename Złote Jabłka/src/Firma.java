import java.util.ArrayList;
import java.util.LinkedList;

public class Firma 
{
    private LinkedList<Statek> statki;

    public Firma(ArrayList<Integer> ładowności_statków)
    {
        for(int i = 0; i < ładowności_statków.size(); i++)
            statki.add(new Statek(ładowności_statków.get(i)));
    }

    public void symujuj_dzień(int numer_dnia, Archipelag archipelag)
    {
        for(Statek s: statki)
            s.symuluj_dzień(numer_dnia, archipelag);
    }

    public void zacznij_nowy_tydzień(ArrayList<ArrayList<Integer>> plany)
    {
        for(int i=0; i< statki.size(); i++)
            statki.get(i).zacznij_nowy_tydzień(plany.get(i));
    }

    public int ile_pestek_w_tygodniu()
    {
        int ile = 0;
        for(Statek s: statki)
            ile += s.ile_łącznie_pestek();
        return ile;
    }
}

import java.util.ArrayList;
public class Wyspa
{
    private ArrayList<Jabłoń> jabłonie;
    public Wyspa(int ile_jabłoni)
    {
        jabłonie = new ArrayList<Jabłoń>(ile_jabłoni);
        for(int i = 0; i < ile_jabłoni; i++)
            jabłonie.add(new Jabłoń());
    }

    public Jabłko daj_najdroższe_do(int limit)
    {
        Jabłoń najciekasza = null;

        for(Jabłoń j: jabłonie)
        {
            if(j.czy_zebrane())
                continue;
            if(
                ((najciekasza == null) && j.koszt_jabłka() <= limit) ||
                (j.koszt_jabłka() > najciekasza.koszt_jabłka() && j.koszt_jabłka() <= limit)
                )
                najciekasza = j;
        }
        if(najciekasza == null)
            return null;
        else 
            return najciekasza.daj_jabłko();
    }
}
import java.util.ArrayList;

public class Archipelag 
{
    private ArrayList<Wyspa> wyspy;
    
    public Archipelag()
    {
        wyspy = new ArrayList<Wyspa>();
    }

    public void dodaj_wyspe(int ile_jabłoni)
    {
        wyspy.add(new Wyspa(ile_jabłoni));
    }

    public Wyspa daj_wyspe(int numer)
    {
        return wyspy.get(numer);
    }
}

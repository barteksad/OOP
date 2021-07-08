import java.util.ArrayList;
import java.util.Random;

public class Talia 
{
    private ArrayList<Karta> karty;
    private int idx;

    public void tasuj() 
    {
        for (int ile = 1; ile <= 5; ile++) 
        {
            ArrayList<Karta> nowa = new ArrayList<Karta>();

            for (int i = 25, j = 26; i >= 0 && j < 52; i--, j++) {
                nowa.add(karty.get(i));
                nowa.add(karty.get(j));
            }
            karty = nowa;

            Random r = new Random();

            int podział = r.nextInt(50);
            nowa = new ArrayList<Karta>();

            for (int j = podział; j < 52; j++) {
                nowa.add(karty.get(j));
            }

            for (int j = 0; j < podział; j++) {
                nowa.add(karty.get(j));
            }

            karty = nowa;
        }

    }

    public Talia() 
    {
        karty = new ArrayList<Karta>();
        idx = 0;
        for (int i = 1; i < 53; i++)
            karty.add(new Karta(i));
        tasuj();
    }

    public Karta daj_karte()
    {
        return karty.get(idx++);
    }
}
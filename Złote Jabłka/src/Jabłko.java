import java.util.Random;

public class Jabłko 
{
    private static Random r = new Random();
    private int liczba_pestek;
    
    public Jabłko()
    {
        liczba_pestek = Jabłko.r.nextInt(6) + 2;
    }

    public int liczba_pestek()
    {
        return liczba_pestek;
    }

    public int koszt()
    {
        return liczba_pestek * 40;
    }
}

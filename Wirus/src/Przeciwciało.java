import java.util.Random;

public class Przeciwciało 
{
    private String kwas_nukleinowy;
    private int długość_kwasu;

    public void uodpornij(Wirus w)
    {
        String kwas_wirusa = w.kwas_nukleinowy();
        Random r = new Random();

        int pos = r.nextInt(kwas_wirusa.length() - długość_kwasu);
        kwas_nukleinowy = kwas_wirusa.substring(pos, pos + długość_kwasu);
    }

    public boolean czy_odporne(Wirus w)
    {
        assert(kwas_nukleinowy.length() > 0);
        String kwas_wirusa = w.kwas_nukleinowy();
        for(int i = 0; i < kwas_wirusa.length() - długość_kwasu; i++)
        {
            boolean zgodne = true;
            for(int j = i; j < długość_kwasu; j++)
                if(kwas_wirusa.charAt(i + j) != kwas_nukleinowy.charAt(j))
                {
                    zgodne = false;
                    break;
                }
            if(zgodne)
                return true;
        }

        return false;
    }

    public Przeciwciało(int długość)
    {
        this.długość_kwasu = długość;
    }
}

import java.util.Random;

public class Dziwny extends Wirus
{
    public Dziwny()
    {
        // 5 mutacji miesięcznie
        super("CGTCGACGGTCGTGTATAACTTATTAACATCTGATTATTGCCCCAATCTTCCCCCCGCGGCAGACGAGGGGGCTTGGCCATTTGTCTGCGCTCGGACTAA", 5);
    }   
    
    @Override
    protected void mutuj()
    {
        Random r = new Random();
        int pos1=-1, pos2=-1;
        while(pos1 == pos2)
        {
            pos1 = r.nextInt(kwas_nukleinowy.length());
            pos2 = r.nextInt(kwas_nukleinowy.length());
        }
        StringBuilder nowy_kwas_nukleinowy = new StringBuilder(kwas_nukleinowy);
        char temp = kwas_nukleinowy.charAt(pos1);
        nowy_kwas_nukleinowy.setCharAt(pos1, kwas_nukleinowy.charAt(pos2));
        nowy_kwas_nukleinowy.setCharAt(pos2, temp);
        kwas_nukleinowy = nowy_kwas_nukleinowy.toString();
    }
}

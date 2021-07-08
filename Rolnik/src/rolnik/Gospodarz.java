package src.rolnik;

public class Gospodarz extends Rolnik
{
    public void simulate(Garden g, int time)
    {
        long czas_start = System.currentTimeMillis();
        int k = g.ile_miejsc_w_ogrodzie();
        for(int p = 0; p < k; p++)
        {
            this.posadź_losowe(g, p);
        }
        float[] wartości = new float[k];

        while(czas_start + time * 1000 >= System.currentTimeMillis())
        {
            this.czekaj(1 * 1000);
            if (czas_start + time * 1000 < System.currentTimeMillis())
                break;

            for(int p = 0; p < k; p++)
            {
                float aktualna_wartość = g.sprawdź_wartość(p);
                if(aktualna_wartość >= wartości[p])
                    wartości[p] = aktualna_wartość;
                else
                {
                    this.zbierz(g, p);
                    this.posadź_losowe(g, p);
                    wartości[p] = 0;
                }
            }
        }

        System.out.print(this);
    }    
}

package src.rolnik;

public class PracownikPGR extends Rolnik
{
    public void simulate(Garden g, int time)
    {
        long czas_start = System.currentTimeMillis();
        int k = g.ile_miejsc_w_ogrodzie();

        while(czas_start + time * 1000 >= System.currentTimeMillis())
        {
            for(int p = 0; p < k; p++)
            {
                this.posadź_losowe(g, p);
            }

            this.czekaj(10 * 1000);
            if (czas_start + time * 1000 < System.currentTimeMillis())
                break;

            for(int p = 0; p < k; p++)
            {
                this.zbierz(g, p);
            }
        }

        System.out.print(this);
    }
}

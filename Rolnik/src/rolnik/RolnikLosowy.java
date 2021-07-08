package src.rolnik;

// losowo czeka od 5 do 15 sekund i losowo zbiera z prawdopodobieństwem 50% i sadzi losowo;
public class RolnikLosowy extends Rolnik
    {
        public void simulate(Garden g, int time)
        {
            long czas_start = System.currentTimeMillis();
            int k = g.ile_miejsc_w_ogrodzie();

            for(int p = 0; p < k; p++)
            {
                this.posadź_losowe(g, p);
            }
    
            while(czas_start + time * 1000 >= System.currentTimeMillis())
            {
                long ile_czekać = Rolnik.generator.nextInt(Integer.SIZE - 1) % 11 + 5;
                this.czekaj(ile_czekać * 1000);
                if (czas_start + time * 1000 < System.currentTimeMillis())
                    break;
    
                for(int p = 0; p < k; p++)
                {
                    if (Rolnik.generator.nextBoolean())
                    {
                        this.zbierz(g, p);
                        this.posadź_losowe(g, p);
                    }
                }
            }
    
            System.out.print(this);
        }    
    }
    


public class Funkcja
{
    private int dziedzina[];
    private int zbiór_wartości[];
    private long masa = 0;
    private int poprzednia_aplikacja = -1;

    public Funkcja(int dziedzina[], int zbiór_wartości[])
    {
        this.dziedzina = dziedzina;
        this.zbiór_wartości = zbiór_wartości;
    }

    public Funkcja(int dziedzina[], Funkcja f)
    {
        this.dziedzina = dziedzina;
        this.zbiór_wartości = new int[dziedzina.length];

        for(int i = 0; i < dziedzina.length; i++)
        {
            zbiór_wartości[i] = f.aplikuj(dziedzina[i]);
            masa += zbiór_wartości[i];
        }
    }

    public Funkcja(int a, int b, int x_min, int x_max)
    {
        this.dziedzina = new int[x_max - x_min + 1];
        this.zbiór_wartości = new int[x_max - x_min + 1];

        for(int i = 0; i < dziedzina.length; i++)
        {
            this.dziedzina[i] = x_min+i;
            this.zbiór_wartości[i] = a * this.dziedzina[i] + b;
            masa = this.zbiór_wartości[i];
        }
    }

    public int aplikuj(int x)
    {
        if(poprzednia_aplikacja != -1)
        {
            if(dziedzina[poprzednia_aplikacja] == x)
                return zbiór_wartości[poprzednia_aplikacja];
            if(poprzednia_aplikacja < dziedzina.length - 1)
            {
                if(dziedzina[poprzednia_aplikacja + 1] == x)
                {
                    poprzednia_aplikacja++;
                    return zbiór_wartości[poprzednia_aplikacja];
                }
            }
            else if(poprzednia_aplikacja > 0)
            {
                if(dziedzina[poprzednia_aplikacja - 1] == x)
                {
                    poprzednia_aplikacja--;
                    return zbiór_wartości[poprzednia_aplikacja];
                }
            }
            
        }
        
        int p=0,k=dziedzina.length - 1;
        int s = (p + k)/2;

        while(p < k)
        {
            if(dziedzina[s] < x)
                k = s - 1;
            else if(dziedzina[s] > x)
                p = s + 1; 
            else
                break;
        }
        poprzednia_aplikacja = x;
        return zbiór_wartości[poprzednia_aplikacja];
        }

    public static long EarthMover(Funkcja f, Funkcja g)
    {
        if(f.masa != g.masa || f.dziedzina.length != g.dziedzina.length)
            return -1;

        long koszt = 0;
        for(int i = 0; i < f.dziedzina.length; i++)
        {
            int jednostkowy = Math.abs(f.zbiór_wartości[i] - g.zbiór_wartości[i]);
            koszt += jednostkowy/2 + jednostkowy % 2;
        }
        return koszt;
    }

    public static long HammingDistance(Funkcja f, Funkcja g)
    {
        if(f.dziedzina.length != g.dziedzina.length)
            return -1;
        
        int koszt = 0;

        for(int i = 0; i < f.dziedzina.length; i++)
        {
            if(f.dziedzina[i] != g.dziedzina[i])
                return -1;
            koszt += Math.abs(f.zbiór_wartości[i] - g.zbiór_wartości[i]);
        }

        return koszt;
    }
}
package src.rolnik;

public class Garden
{
    private Warzywo[] miejsca;

    public Garden(int k)
    {
        this.miejsca = new Warzywo[k];
    }

    public int ile_miejsc_w_ogrodzie()
    {
        return this.miejsca.length;
    }

    public float posadź(Warzywo w, int p)
    {
        this.miejsca[p] = w;
        return w.daj_koszt_posadzenia();
    }

    public Warzywo zbierz(int p)
    {
        Warzywo w = this.miejsca[p];
        this.miejsca[p] = null;
        return w;
    }

    public float sprawdź_wartość(int p)
    {
        return this.miejsca[p].daj_wartość();
    }

    public boolean sprawdź_czy_wolne(int p)
    {
        return this.miejsca[p] != null;
    }
}
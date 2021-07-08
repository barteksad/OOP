public abstract class Wirus
{
    protected String kwas_nukleinowy;
    protected int ile_mutacji_miesięcznie;

    protected abstract void mutuj();

    private void symuluj_miesiąc()
    {
        for(int i = 0; i < ile_mutacji_miesięcznie; i++)
            mutuj();
    }

    public void symuluj_n_miesięcy(int n)
    {
        while(n-- > 0)
            symuluj_miesiąc();
    }

    public Wirus(String kwas_nukleinowy, int ile_mutacji_miesięcznie)
    {
        this.kwas_nukleinowy = kwas_nukleinowy;
        this.ile_mutacji_miesięcznie = ile_mutacji_miesięcznie;
    }

    public String kwas_nukleinowy()
    {
        return kwas_nukleinowy;
    }
} 
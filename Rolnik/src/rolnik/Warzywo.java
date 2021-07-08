package src.rolnik;

public abstract class Warzywo
{
    private String nazwa;
    protected long czas_posadzenia;

    public Warzywo(String nazwa, long czas_posadzenia)
    {
        this.nazwa = nazwa;
        this.czas_posadzenia = czas_posadzenia;
    }

    abstract public float daj_wartość();

    abstract public float daj_koszt_posadzenia();

    public String toString()
    {
        return this.nazwa;
    }
}
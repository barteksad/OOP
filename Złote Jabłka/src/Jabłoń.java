public class Jabłoń 
{
    private Jabłko jabłko;
    private boolean czy_zebrane;
    
    public void generuj_nowe_jabłko()
    {
        jabłko = new Jabłko();
    }

    public boolean czy_zebrane()
    {
        return czy_zebrane;
    }

    public int koszt_jabłka()
    {
        return jabłko.koszt();
    }

    public Jabłko daj_jabłko()
    {
        czy_zebrane = true;
        return jabłko;
    }
}

public class Main {
    public static void main(String[] args) throws Exception 
    {
        Dziwny dziwny = new Dziwny();
        Przeciwciało p = new Przeciwciało(50);
        p.uodpornij(dziwny);
        dziwny.symuluj_n_miesięcy(10);
        System.out.println(p.czy_odporne(dziwny));
    }
}

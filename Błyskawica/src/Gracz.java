import java.util.ArrayList;

public class Gracz 
{
    private int nr_gracza;
    private int saldo;
    private ArrayList<Karta> karty;

    public Gracz(int saldo, int nr_gracza)
    {
        this.nr_gracza = nr_gracza;
        this.saldo = saldo;
        karty = new ArrayList<Karta>();
    }

    public void dodaj_karte(Karta k)
    {
        karty.add(k);
    }

    public Karta zgłoś_najstarszą()
    {
        Karta najstarsza = karty.get(0);

        for(Karta k: karty)
            if(Karta.porównaj(najstarsza, k) == -1)
                najstarsza = k;

        return najstarsza;
    }

    public void dodaj_wygraną(int kwota)
    {
        saldo += kwota;
    }

    public void daj_stawke(int stawka)
    {
        saldo -= stawka;
    }

    public boolean czy_może_dalej_grać(int stawka)
    {
        return stawka <= saldo;
    }

    public void usuń_karty()
    {
        karty = new ArrayList<Karta>();
    }

    @Override
    public String toString()
    {
        String s = "";
        for(Karta k: karty)
            s += k + "\n";

        return s;
    }

    public int nr_gracza()
    {
        return numer;
    }
}

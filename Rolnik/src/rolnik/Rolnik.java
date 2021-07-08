package src.rolnik;
import java.util.ArrayList;
import java.util.Random;
import src.rolnik.warzywa.*;

public abstract class Rolnik
{
    protected float zarobek;
    private ArrayList<Warzywo> zebrane_warzywa;
    protected static Random generator = new Random(42);

    Rolnik()
    {
        this.zarobek = 0;
        this.zebrane_warzywa = new ArrayList<>();
    }


    abstract public void simulate(Garden g, int time);

    protected void zbierz(Garden g, int p)
    {
        Warzywo w  = g.zbierz(p);
        float wartość = Math.round(w.daj_wartość() * 100)/100;

        System.out.println("Zebrałem: " + w + " (wartość " + wartość + " PLN)");

        this.zarobek += wartość;
        this.zebrane_warzywa.add(w);
    }

    protected void posadź_losowe(Garden g, int p)
    {
        int wybór = Rolnik.generator.nextInt(Integer.SIZE - 1) % 3;
        Warzywo w;

        switch(wybór)
        {
            case 0:
                w = new Ziemniak();
                break;
            case 1:
                w = new Pomidor();
                break;
            case 2:
                w = new Ogórek();
                break;
            default:
                w = new Ziemniak();
        }

        this.posadź(g, w, p);
    }

    protected void posadź(Garden g, Warzywo w, int p)
    {
        System.out.println("Sadzę " + w + " za " + w.daj_koszt_posadzenia() + " PLN");
        this.zarobek -= g.posadź(w, p);
    }

    protected void czekaj(long ile)
    {
        System.out.println("Czekam " + ile/1000 + " sekund");
        try
        {
            Thread.sleep(ile);
        } catch (Exception e){;}
    }

    public String toString()
    {
        String r = "";
        r += "Wychodowane warzywa i zarobek\n";
        for(Warzywo w: zebrane_warzywa)
        {
            r += " -" + w + "\n";
        }
        r += this.zarobek + " PLN\n";

        return r;
    }
}
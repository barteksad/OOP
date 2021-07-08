package src.rolnik.warzywa;
import src.rolnik.Warzywo;

public class Ziemniak extends Warzywo{

    public float daj_wartość()
    {
        long aktualny_czas = System.currentTimeMillis();

        // przez pierwsze 10sek wartość to 0, potem 5
        if (this.czas_posadzenia + 1000*10 > aktualny_czas)
            return 0;
        else 
            return 5;
    }

    public float daj_koszt_posadzenia()
    {
        return 0.30f;
    }

    public Ziemniak()
    {
        super("ziemniak", System.currentTimeMillis());
    }
}

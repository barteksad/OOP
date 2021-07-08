package src.rolnik.warzywa;
import src.rolnik.Warzywo;

public class Ogórek extends Warzywo
{
    public float daj_wartość()
    {
        long aktualny_czas = System.currentTimeMillis();

        // przez pierwsze 4sek wartość to 0, potem przez 6 sek wartość to 3 a potem przez 10 sek maleje liniowo do 0
        if (this.czas_posadzenia + 1000*4 > aktualny_czas)
            return 0;
        if (this.czas_posadzenia + 1000*10 > aktualny_czas)
            return 3;
        if (this.czas_posadzenia + 1000*20 > aktualny_czas)
            return 3f * (float)(Math.abs(aktualny_czas - czas_posadzenia - 20f * 1000f)/10000f);
        return 0;
    }

    public float daj_koszt_posadzenia()
    {
        return 0.70f;
    }

    public Ogórek()
    {
        super("ogórek", System.currentTimeMillis());
    }
}

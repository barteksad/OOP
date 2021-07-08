package src.rolnik.warzywa;

import src.rolnik.Warzywo;

public class Pomidor extends Warzywo{

    public float daj_wartość()
    {
        long aktualny_czas = System.currentTimeMillis();

        // przez pierwsze 10sek wartość to 0, potem przez 5 rośnie liniowo do 5 i potem przez 5 mmaleje liniowo do 5
        if (this.czas_posadzenia + 1000*10 > aktualny_czas)
            return 0;
        else if (this.czas_posadzenia + 1000*20 > aktualny_czas)
            return 5.0f - (float)(Math.abs(aktualny_czas - czas_posadzenia - 15f * 1000f)/1000f);
        else
            return 0;
    }

    public float daj_koszt_posadzenia()
    {
        return 0.85f;
    }

    public Pomidor()
    {
        super("pomidor", System.currentTimeMillis());
    }
}

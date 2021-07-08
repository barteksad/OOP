import java.util.Random;

public class SędziaLosowy extends Sędzia {

    private Random stan;
    private int oskarżyciel_szanse;
    private int oskarżony_szanse;
    private int umorzenie_szanse;

    public SędziaLosowy(int stan_konta,int oskarżyciel_szanse, int oskarżony_szanse, int umorzenie_szanse) {
        super(stan_konta);
        stan = new Random();
        this.oskarżyciel_szanse = oskarżyciel_szanse;
        this.oskarżony_szanse = oskarżony_szanse;
        this.umorzenie_szanse = umorzenie_szanse;
    }


    @Override
    public Werdykt rozpatrzSpór(Spór spór) {
        int chumor = stan.nextInt(101);

        if(oskarżyciel_szanse <= chumor)
            return Werdykt.przyznanie_winy;
        else if(oskarżyciel_szanse + oskarżony_szanse <= chumor)
            return Werdykt.uniewinnienie;
        else
            return Werdykt.umorzenie;
    }
}

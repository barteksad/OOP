
public class SędziaRzadkościowy extends Sędzia{

    public SędziaRzadkościowy(int stan_konta) {
        super(stan_konta);
    }

    @Override
    public Werdykt rozpatrzSpór(Spór spór) {

        int oskarżający_ile_razy_skazany = spór.getOskarżyciel().getIle_razy_skazany();
        int oskarżony_ile_razy_skazany = spór.getOskarżony().getIle_razy_skazany();

        int różnica = oskarżający_ile_razy_skazany - oskarżony_ile_razy_skazany;

        if(różnica < 0)
            return Werdykt.przyznanie_winy;
        else if(różnica == 0)
            return Werdykt.umorzenie;
        else
            return Werdykt.uniewinnienie;
    }
}

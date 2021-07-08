import java.util.ArrayList;

public class SędziaMniejszościowy extends Sędzia {

    public SędziaMniejszościowy(int stan_konta) {
        super(stan_konta);
    }

    @Override
    public Werdykt rozpatrzSpór(Spór spór) {
        ArrayList<Spór> spory_oskarżającego = spór.getOskarżyciel().getPoprzednie_spory();
        ArrayList<Spór> spory_oskarżonego = spór.getOskarżony().getPoprzednie_spory();

        int oskarżający_kwoty_umorzone = 0;
        int oskarżony_kwoty_umorzone = 0;

        for(Spór s: spory_oskarżającego)
            if(s.getWerdykt().equals(Werdykt.umorzenie))
                oskarżający_kwoty_umorzone += s.getKwota();
        for(Spór s: spory_oskarżonego)
            if(s.getWerdykt().equals(Werdykt.umorzenie))
                oskarżony_kwoty_umorzone += s.getKwota();

        int różnica = oskarżający_kwoty_umorzone - oskarżony_kwoty_umorzone;

        if(różnica < 0)
            return Werdykt.przyznanie_winy;
        else if(różnica == 0)
            return Werdykt.umorzenie;
        else
            return Werdykt.uniewinnienie;
    }
    
}

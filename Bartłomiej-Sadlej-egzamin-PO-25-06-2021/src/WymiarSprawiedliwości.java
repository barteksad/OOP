public class WymiarSprawiedliwości {
    private Sąd sąd_najwyższy;

    public WymiarSprawiedliwości() {
        generur_sądy_i_przypisz_sędziów();
    }

    private Sąd ustal_sąd_początkowy(Obywatel oskarżyciel) {
        // nie implementuje dokładnie
        return sąd_najwyższy; 
    }

    public void inicjujSpór(Obywatel oskarżyciel, String stanowisko_oskarżającego, String stanowisko_oskarżonego, Obywatel oskarżony, int kwota) {
        if(oskarżyciel.isImmunitet() || oskarżony.isImmunitet())
            return;
        
        oskarżyciel.setStanowisko(stanowisko_oskarżającego);
        oskarżony.setStanowisko(stanowisko_oskarżonego);

        Sąd początkowy = ustal_sąd_początkowy(oskarżyciel);
        Spór spór = new Spór(oskarżyciel, oskarżony, kwota);

        Werdykt werdykt = początkowy.rozpatrzSpór(spór);

        switch(werdykt) {
            case przyznanie_winy:
                oskarżony.wypłać(kwota);
                oskarżyciel.wpłać(kwota);
                oskarżony.zwiększIle_razy_skazany();
                spór.setWerdykt(Werdykt.przyznanie_winy);
                oskarżyciel.dodajSpór(spór);
            case umorzenie:
                spór.setWerdykt(Werdykt.umorzenie);
                oskarżyciel.dodajSpór(spór);
            case uniewinnienie:
                oskarżyciel.wypłać(kwota);
                oskarżony.wpłać(kwota);
                spór.setWerdykt(Werdykt.uniewinnienie);
                oskarżyciel.dodajSpór(spór);
            default:
                assert(false);
        }
    }

    private void generur_sądy_i_przypisz_sędziów() {
        // nie implementuje dokładnie
        return;
    }
}

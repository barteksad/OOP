public class SędziaDługościowy extends Sędzia {

    public SędziaDługościowy(int stan_konta) {
        super(stan_konta);
    }

    @Override
    public Werdykt rozpatrzSpór(Spór spór) {
        int porównanie_długości = spór.getOskarżyciel().getStanowisko().length() - spór.getOskarżony().getStanowisko().length();
        
        if(porównanie_długości < 0)
            return Werdykt.przyznanie_winy;
        else if(porównanie_długości == 0)
            return Werdykt.umorzenie;
        else
            return Werdykt.uniewinnienie;
    }
    
}

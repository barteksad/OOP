import java.util.ArrayList;

public class Obywatel {
    
    private String stanowisko;
    private int stan_konta;
    private int ile_razy_skazany;
    private boolean immunitet;
    private ArrayList<Spór> poprzednie_spory;
    
    public Obywatel(int stan_konta, boolean immunitet) {
        this.stan_konta = stan_konta;
        this.immunitet = immunitet;
        this.ile_razy_skazany = 0;
        this.poprzednie_spory = new ArrayList<Spór>();
    }
    
    public Obywatel(int stan_konta) {
        this.stan_konta = stan_konta;
        this.immunitet = false;
        this.ile_razy_skazany = 0;
        this.poprzednie_spory = new ArrayList<Spór>();
    }
    
    
    public String getStanowisko() {
        return stanowisko;
    }
    
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
    
    public boolean isImmunitet() {
        return immunitet;
    }
    
    public ArrayList<Spór> getPoprzednie_spory() {
        return poprzednie_spory;
    }
    
    public int getIle_razy_skazany() {
        return ile_razy_skazany;
    }

    public void zwiększIle_razy_skazany() {
        this.ile_razy_skazany += 1;
    }
    
    public void dodajSpór(Spór spór) {
        poprzednie_spory.add(spór);
    }


    public void wypłać(int ile) {
        stan_konta -= ile;
    }

    public void wpłać(int ile) {
        stan_konta += ile;
    }

    
}

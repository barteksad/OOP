import java.util.ArrayList;

public class Gra 
{
    private int nr_rozdania;
    private ArrayList<Gracz> gracze;
    private int stawka;

    public Gra(ArrayList<Gracz> gracze, int stawka)
    {
        this.gracze = gracze;
        this.stawka = stawka;
        nr_rozdania = 1;
    }    

    public void symuluj()
    {
        boolean gramy_dalej = true;
        for(Gracz g: gracze)
                gramy_dalej = g.czy_może_dalej_grać(stawka);

        while(gramy_dalej)
        {
            int pula = gracze.size() * stawka;
            for(Gracz g: gracze)
                g.daj_stawke(stawka);

            Talia talia = new Talia();
            talia.tasuj();

            for(int i = 1; i <= 5; i++)
                for(Gracz g: gracze)
                    g.dodaj_karte(talia.daj_karte());

            for(Gracz g: gracze)
                gramy_dalej = g.czy_może_dalej_grać(stawka);

            Karta najstarsza = gracze.get(0).zgłoś_najstarszą();
            Gracz wygrywający = gracze.get(0);

            for(Gracz g: gracze)
            {
                Karta k = g.zgłoś_najstarszą();

                if(Karta.porównaj(najstarsza, k) == -1)
                {
                    najstarsza = k;
                    wygrywający = g; 
                }
            }

            wygrywający.dodaj_wygraną(pula);

            wypisz_rozdanie(wygrywający);

            for(Gracz g: gracze)
            {
                gramy_dalej = g.czy_może_dalej_grać(stawka);
                g.usuń_karty();
            }
            nr_rozdania++;
        }

    }

    public void wypisz_rozdanie(Gracz wygrywający)
    {
        System.out.println("Rozdanie numer: " + nr_rozdania);
        System.out.println("wygrał gracz nr: "+wygrywający.nr_gracza()+ " z kartami: \n" + wygrywający);
        System.out.println("karty pozostałych graczy :");
        for(Gracz g: gracze)
        {
            if(g != wygrywający)
                System.out.println("Gracz nr: " + g.nr_gracza() + " karty:\n"+ g);
        }
        
    
        
    }
}

package Czytelnicy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import Książki.Książka;
import dane.ZapamiętanaDana;

abstract public class Czytelnik {

    private Random generator;
    private boolean czy_pierwsza_książka_dziś;
    protected Map<String, ArrayList<ZapamiętanaDana>> zapamiętane_książki;
    private ArrayList<ZapamiętanaDana> preferencje;
    private Książka aktualnie_czytana;

    public Czytelnik(ArrayList<ZapamiętanaDana> preferencje) {
        this.generator = new Random();
        this.czy_pierwsza_książka_dziś = true;
        this.zapamiętane_książki = new LinkedHashMap<String, ArrayList<ZapamiętanaDana>>();
        this.preferencje = preferencje;
        this.aktualnie_czytana = null;
    }

    public boolean czyWziąćKsiążke() {
        if(czy_pierwsza_książka_dziś)
            return true;
        else 
            return generator.nextBoolean();
    }

    public Książka oddajKsiążkę() {
        return aktualnie_czytana = null;
    }

    public void wypożyczKsiążkę(Książka książka) {
        aktualnie_czytana = książka;
        String id = książka.getNazwiskoAutora() + " : " + książka.getTytuł(); 

        if(!zapamiętane_książki.containsKey(id)) {
            ArrayList<ZapamiętanaDana> dane_książki = new ArrayList<ZapamiętanaDana>();

            for(ZapamiętanaDana dana: preferencje) {
                dane_książki.add(dana.zapamiętaj(aktualnie_czytana));
            }

            zapamiętane_książki.put(id, dane_książki);
        }
    }
    
}

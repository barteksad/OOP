import java.util.ArrayList;
import java.util.Queue;

import Czytelnicy.Czytelnik;
import Książki.Książka;

public class Biblioteka {

    private int n;
    private ArrayList<Książka> książki;

    public Biblioteka(int n) {
        this.n = n;
        książki = new ArrayList<Książka>();
    }

    private void przyjmijZwrotKsiążki(Książka książka) {
        return;
    }

    private Książka wypożyczKsiążkę() {
        return książki.get(0);
    }
    
    public void symulujDzień(Queue<Czytelnik> czytelnicy) {
        if(czytelnicy.size() == 0)
            return;

        for(int i = 0; i < n; i++) {
            Czytelnik aktualny = czytelnicy.poll();

            Książka możliweŻeOddana = aktualny.oddajKsiążkę();
            przyjmijZwrotKsiążki(możliweŻeOddana);

            if(aktualny.czyWziąćKsiążke()) {
                aktualny.wypożyczKsiążkę(this.wypożyczKsiążkę());
                czytelnicy.add(aktualny);
            }
        }

        for(Czytelnik aktualny: czytelnicy) {
            Książka możliweŻeOddana = aktualny.oddajKsiążkę();
            przyjmijZwrotKsiążki(możliweŻeOddana);
        }

    }

}

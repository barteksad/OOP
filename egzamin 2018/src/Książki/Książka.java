package Książki;

import java.util.ArrayList;

public class Książka{
    
    private String nazwisko_autora;
    private String tytuł;
    private int rok;
    private ArrayList<String> treść;

    public Książka(String nazwisko_autora, String tytuł, int rok, String treść) {
        this.nazwisko_autora = nazwisko_autora;
        this.tytuł = tytuł;
        this.rok = rok;
        this.treść = new ArrayList<String>();
        
        for(String słowo: treść.split(" ")) {
            this.treść.add(słowo);
        }
    }
    
    public String getNazwiskoAutora() {
        return nazwisko_autora;
    }

    public String getTytuł() {
        return tytuł;
    }

    public int getRok() {
        return rok;
    }

    public ArrayList<String> getTreść() {
        return treść;
    }

}

package dane;

import Książki.Książka;

public class PierwszeSłowo extends ZapamiętanaDana{

    private String słowo;

    public PierwszeSłowo() {
        ;
    }

    public PierwszeSłowo(String słowo) {
        this.słowo = słowo;
    }

    @Override
    public ZapamiętanaDana zapamiętaj(Książka aktualnie_czytana) {
        return new PierwszeSłowo(aktualnie_czytana.getTreść().get(0));
    }
    
    @Override 
    public String toString() {
        return "pierwsze słowo: " + słowo;
    }
}

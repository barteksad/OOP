package dane;

import Książki.Książka;

public class JakDługa extends ZapamiętanaDana{

    private int jak;

    public JakDługa(int jak) {
        this.jak = jak;
    }

    public JakDługa() {
        ;
    }

    @Override
    public ZapamiętanaDana zapamiętaj(Książka aktualnie_czytana) {
        return new JakDługa(aktualnie_czytana.getTreść().size());
    }

    @Override
    public String toString() {
        return "liczba słów: " + jak;
    }
    
}

package dane;

import Książki.Książka;

public class IleRazySłowo extends ZapamiętanaDana {

    private String słowo;
    private int ile;

    public IleRazySłowo(String słowo, int ile) {
        this.słowo = słowo;
        this.ile = ile;
    }

    public IleRazySłowo(String słowo) {
        this.słowo = słowo;
    }

    @Override
    public ZapamiętanaDana zapamiętaj(Książka aktualnie_czytana) {
        int n_ile = 0;

        for(String t_słowo: aktualnie_czytana.getTreść())
            if(słowo.equals(t_słowo))
                ile++;

        return new IleRazySłowo(słowo, n_ile);
    }
    
    @Override
    public String toString() {
        return słowo + " występuje " + ile + " razy";
    }
}

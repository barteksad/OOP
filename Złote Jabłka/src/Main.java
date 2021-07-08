import java.util.ArrayList;

public class Main {

    int[] przeprowadźTydzień(Firma[] firmy, Archipelag archipelag,ArrayList<ArrayList<ArrayList<Integer> >> plany)
    {
        for(int i = 0; i < firmy.length; i++)
            firmy[i].zacznij_nowy_tydzień(plany.get(i));
        for(int i = 0; i < 7; i++)
        {
            for(Firma f: firmy)
                f.symujuj_dzień(i, archipelag);
        }

        int wyniki[] = new int[firmy.length];
        for(int i = 0; i < firmy.length; i ++)
            wyniki[i] = firmy[i].ile_pestek_w_tygodniu();
        return wyniki;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

import java.util.ArrayList;
import java.util.Queue;

import Kolekcjonerzy.Kolekcjoner;
import Wyjątki.ZeroKolekcjonerów;
import ciągi.Ciąg;

public class ZlotKolekcjonerów {
    
    public void rozdajCiągi(ArrayList<Kolekcjoner> kolekcjonerzy, Queue<Ciąg> ciągi) throws WyjątekNaZlocie {
        if (kolekcjonerzy.size() == 0)
            throw new ZeroKolekcjonerów();

        while(!ciągi.isEmpty()) {

            for(int i = 0; i < kolekcjonerzy.size(); i++) {

                Kolekcjoner aktualny = kolekcjonerzy.get(i);
                
                if(aktualny.czyPasuje(ciągi.peek())) {
                    aktualny.dodajCiąg(ciągi.peek());
                    kolekcjonerzy.remove(i);
                    kolekcjonerzy.add(kolekcjonerzy.size() - 1, aktualny);
                    break;
                }
            }
            
            ciągi.poll();
        }

        for(Kolekcjoner kolekcjoner: kolekcjonerzy) 
            System.out.println(kolekcjoner);

    } 
}

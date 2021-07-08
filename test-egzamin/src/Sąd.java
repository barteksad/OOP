import java.util.ArrayList;
import java.util.PriorityQueue;

public class Sąd {
    private Sąd wyższa_instancja;
    private ArrayList<Sąd> niższe_instancje;
    private PriorityQueue<Sędzia> sędziowie;

    public Sąd(Sąd wyższa_instancja, ArrayList<Sąd> niższe_instancje, ArrayList<Sędzia> sędziowie) {
        this.wyższa_instancja = wyższa_instancja;
        this.niższe_instancje = niższe_instancje;
        this.sędziowie = new PriorityQueue<Sędzia>();
        for(Sędzia s: sędziowie)
            sędziowie.add(s);
    }

    public ArrayList<Sąd> getNiższe_instancje() {
        return niższe_instancje;
    }

    public Werdykt rozpatrzSpór(Spór spór) {
        Sędzia sędzia = sędziowie.poll();
        Werdykt werdykt = sędzia.rozpatrzSpór(spór);
        sędzia.zwiększIleRozpatrzonychSpraw();

        if(werdykt == Werdykt.umorzenie || werdykt == Werdykt.uniewinnienie)
            if(wyższa_instancja != null)
                return wyższa_instancja.rozpatrzSpór(spór);

        return werdykt;

    }
}

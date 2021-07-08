abstract public class Sędzia extends Obywatel implements Comparable<Sędzia> {

    private int ile_rozpatrzonych_spraw;

    public Sędzia(int stan_konta) {
        super(stan_konta, true);
        ile_rozpatrzonych_spraw = 0;
    }

    @Override
    public int compareTo(Sędzia s) {
        if(s == null)
            return 0;
        else
            return ile_rozpatrzonych_spraw - s.getIleRozpatrzonychSpraw();
    }

    public int getIleRozpatrzonychSpraw() {
        return ile_rozpatrzonych_spraw;
    }

    public void zwiększIleRozpatrzonychSpraw() {
        ile_rozpatrzonych_spraw++;
    }

    abstract public Werdykt rozpatrzSpór(Spór spór);
}

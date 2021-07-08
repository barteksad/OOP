package Kolekcjonerzy;

import java.util.ArrayList;

import ciągi.Ciąg;

abstract public class Kolekcjoner {

    private ArrayList<Ciąg<?>> ciągi;

    public Kolekcjoner() {
        ciągi = new ArrayList<Ciąg<?>>();
    }
    
    abstract public boolean czyPasuje(Ciąg<?> ciąg);

    public void dodajCiąg(Ciąg<?> ciąg) {
        ciągi.add(ciąg);
    }

    @Override
    public String toString() {
        StringBuilder acc = new StringBuilder();

        for(Ciąg<?> ciąg: ciągi)
            acc.append(ciąg + "\n");

        return acc.toString();
    }
    
}

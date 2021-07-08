package src;
import src.rolnik.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Main {

    // public static void main(String[] args)
    // {

    //     Rolnik rolnik_losowy = new RolnikLosowy();
    //     Rolnik pracownik_pgr = new PracownikPGR();
    //     Rolnik gospodarz = new Gospodarz();
        
    //     for(int i = 1; i <= 3; i++)
    //     {
    //         Garden g = new Garden(20);
    //         rolnik_losowy.simulate(g, 40);
    //     }
    // }

    @Test
    void gospodarz() {
        Rolnik gospodarz = new Gospodarz();
        Garden g = new Garden(20);
        gospodarz.simulate(g, 40);
        // Powinno wyjść 24.5 (z dokładnością do 2 miejsc po przecinku)
    }


    @Test
    void pracownik_prg() {
        Rolnik pracownik_pgr = new PracownikPGR();
        Garden g = new Garden(20);
        pracownik_pgr.simulate(g, 40);
        // Powinno wyjść 60 (z dokładnością do 2 miejsc po przecinku)
    }

    @Test
    void rolnik_losowy() {
        Rolnik rolnik_losowy = new RolnikLosowy();
        Garden g = new Garden(20);
        rolnik_losowy.simulate(g, 40);
        // Losowo (z dokładnością do 2 miejsc po przecinku)
    }

}

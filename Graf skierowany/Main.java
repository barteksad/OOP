import Graph.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class Main 
{
    public static void main(String[] args)
    {
        Graph g = new Graph();
        g.dodaj_wierchołek(1);
        g.dodaj_wierchołek(2);
        g.dodaj_wierchołek(3);
        g.dodaj_wierchołek(4);
        g.dodaj_wierchołek(5);

        g.dodaj_krawędź(1, 2, 5);
        g.dodaj_krawędź(2, 3, 15);
        g.dodaj_krawędź(3, 4, 1);
        g.dodaj_krawędź(4, 5, 4);
        g.dodaj_krawędź(5, 1, 4);
        g.dodaj_krawędź(4, 1, 15);
        g.dodaj_krawędź(2, 5, 20);
        
        Graph q = g.minimalne_drzewo_rozpinające();
        System.out.println(q.toString());    
    }

    @Test
    void test1()
    {
        Graph g = new Graph();
        g.dodaj_wierchołek(1);
        g.dodaj_wierchołek(2);
        g.dodaj_wierchołek(3);
        g.dodaj_wierchołek(4);
        g.dodaj_wierchołek(5);

        g.dodaj_krawędź(1, 2, 5);
        g.dodaj_krawędź(2, 3, 15);
        g.dodaj_krawędź(1, 4, 1);
        g.dodaj_krawędź(2, 4, 3);
        g.dodaj_krawędź(4, 5, 4);

        assertEquals(false, g.czy_w_cyklu(1));
    }

    @Test
    void test3()
    {
        Graph g = new Graph();
        g.dodaj_wierchołek(1);
        g.dodaj_wierchołek(2);
        g.dodaj_wierchołek(3);
        g.dodaj_wierchołek(4);
        g.dodaj_wierchołek(5);

        g.dodaj_krawędź(1, 2, 5);
        g.dodaj_krawędź(2, 3, 15);
        g.dodaj_krawędź(3, 4, 1);
        g.dodaj_krawędź(4, 5, 4);
        g.dodaj_krawędź(5, 1, 4);
        g.dodaj_krawędź(4, 1, 15);
        g.dodaj_krawędź(2, 5, 20);
        
        Graph q = g.minimalne_drzewo_rozpinające();
        assertEquals("skąd/gdzie/(koszt)\n3: 4 (1),\n4: 3 (1), 5 (4),\n1: 5 (4),\n5: 1 (4), 4 (4),", q.toString());
    }

    @Test
    void test4()
    {
        Graph g = new Graph();
        g.dodaj_wierchołek(1);
        g.dodaj_wierchołek(2);
        g.dodaj_wierchołek(3);
        g.dodaj_wierchołek(4);
        g.dodaj_wierchołek(5);

        g.dodaj_krawędź(1, 2, 5);
        g.dodaj_krawędź(2, 3, 15);
        g.dodaj_krawędź(3, 4, 1);
        g.dodaj_krawędź(4, 5, 4);
        g.dodaj_krawędź(5, 1, 4);
        g.dodaj_krawędź(4, 1, 15);
        g.dodaj_krawędź(2, 5, 20);
        String s = g.najkrótsza_ścierzka(3,5);
        assertEquals("3 4 5 (5)", s);
    }
    @Test
    void test5()
    {
        Graph g = new Graph();
        g.dodaj_wierchołek(1);
        g.dodaj_wierchołek(2);
        g.dodaj_wierchołek(3);
        g.dodaj_wierchołek(4);
        g.dodaj_wierchołek(5);
        g.dodaj_wierchołek(6);
        g.dodaj_wierchołek(7);

        g.dodaj_krawędź(1, 2, 5);
        g.dodaj_krawędź(2, 3, 15);
        g.dodaj_krawędź(3, 4, 1);
        g.dodaj_krawędź(4, 5, 4);
        g.dodaj_krawędź(5, 1, 4);
        g.dodaj_krawędź(4, 1, 15);
        g.dodaj_krawędź(2, 6, 5);
        g.dodaj_krawędź(1, 6, 2);
        String s = g.najkrótsza_ścierzka(3,6);
        System.out.println(s);
        assertEquals("3 4 5 1 6 (11)", s);
    }

}

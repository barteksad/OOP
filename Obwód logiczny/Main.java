import java.util.Arrays;
import java.util.ArrayList;
import src.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        Bramka i1 = new Plus();
        Bramka i2 = new Plus(); 
        Bramka i3 = new Plus(); 
        Bramka i4 = new Or(8);
        
        Bramka o1 = new Or(2);
        Bramka o2 = new Plus();

        Bramka o3 = new Plus();
        
        Wierzchołek out1 = new Wierzchołek(o3);

        Wierzchołek ob1 = new Wierzchołek(o1, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek ob2 = new Wierzchołek(o2, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(1)));


        Wierzchołek inp1 = new Wierzchołek(i1, new ArrayList<Wierzchołek>(Arrays.asList(ob1)),  new ArrayList<Integer>(Arrays.asList(1)));
        Wierzchołek inp2 = new Wierzchołek(i2, new ArrayList<Wierzchołek>(Arrays.asList(ob2)),  new ArrayList<Integer>(Arrays.asList(1)));
        Wierzchołek inp3 = new Wierzchołek(i3, new ArrayList<Wierzchołek>(Arrays.asList(ob1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek inp4 = new Wierzchołek(i4, new ArrayList<Wierzchołek>(Arrays.asList(ob2)),  new ArrayList<Integer>(Arrays.asList(0)));

        Circuit obw = new Circuit();

        obw.add(out1, false);
        obw.add(ob1, false);
        obw.add(ob2, false);
        obw.add(inp1, true);
        obw.add(inp2, true);
        obw.add(inp3, true);
        obw.add(inp4, true);

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0,1,3,5, 0,0, 0,0,0,0,0,1,0,0));
        ArrayList<Integer> out = obw.execute(input);

        System.out.println(out);
    }

    @Test
    void test1()
    {
        Bramka i1 = new Plus();
        Bramka i2 = new Plus(); 
        Bramka o1 = new Or(2);
        
        Wierzchołek out1 = new Wierzchołek(o1);
        Wierzchołek inp1 = new Wierzchołek(i1, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek inp2 = new Wierzchołek(i2, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(1)));

        Circuit obw = new Circuit();

        obw.add(out1, false);
        obw.add(inp1, true);
        obw.add(inp2, true);

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0,1,0,1));
        ArrayList<Integer> out = obw.execute(input);

        assertEquals("[1]", out.toString());
    }

    @Test
    void test2()
    {
        Bramka i1 = new Plus();
        Bramka i2 = new Plus(); 
        Bramka o1 = new Plus();
        
        Wierzchołek out1 = new Wierzchołek(o1);
        Wierzchołek inp1 = new Wierzchołek(i1, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek inp2 = new Wierzchołek(i2, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(1)));

        Circuit obw = new Circuit();

        obw.add(out1, false);
        obw.add(inp1, true);
        obw.add(inp2, true);

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0,1,0,1));
        ArrayList<Integer> out = obw.execute(input);

        assertEquals("[2]", out.toString());
    }

    @Test
    void test3()
    {
        Bramka i1 = new Plus();
        Bramka i2 = new Plus(); 
        Bramka i3 = new Plus(); 
        Bramka i4 = new Or(8);
        
        Bramka o1 = new Or(2);
        Bramka o2 = new Plus();

        Bramka o3 = new Plus();
        
        Wierzchołek out1 = new Wierzchołek(o3);

        Wierzchołek ob1 = new Wierzchołek(o1, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek ob2 = new Wierzchołek(o2, new ArrayList<Wierzchołek>(Arrays.asList(out1)),  new ArrayList<Integer>(Arrays.asList(1)));


        Wierzchołek inp1 = new Wierzchołek(i1, new ArrayList<Wierzchołek>(Arrays.asList(ob1)),  new ArrayList<Integer>(Arrays.asList(1)));
        Wierzchołek inp2 = new Wierzchołek(i2, new ArrayList<Wierzchołek>(Arrays.asList(ob2)),  new ArrayList<Integer>(Arrays.asList(1)));
        Wierzchołek inp3 = new Wierzchołek(i3, new ArrayList<Wierzchołek>(Arrays.asList(ob1)),  new ArrayList<Integer>(Arrays.asList(0)));
        Wierzchołek inp4 = new Wierzchołek(i4, new ArrayList<Wierzchołek>(Arrays.asList(ob2)),  new ArrayList<Integer>(Arrays.asList(0)));

        Circuit obw = new Circuit();

        obw.add(out1, false);
        obw.add(ob1, false);
        obw.add(ob2, false);
        obw.add(inp1, true);
        obw.add(inp2, true);
        obw.add(inp3, true);
        obw.add(inp4, true);

        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0,1,3,5, 0,0, 0,0,0,0,0,1,0,0));
        ArrayList<Integer> out = obw.execute(input);
        assertEquals("[10]", out.toString());
    }
}

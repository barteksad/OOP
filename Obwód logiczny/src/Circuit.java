package src;

import java.util.ArrayList;

public class Circuit 
{
    private ArrayList<Wierzchołek> nodes;
    private Ostatni last;
    private boolean isOptimized = true;

    public void add(Wierzchołek w, boolean isInput)
    {
        nodes.add(w);
        isOptimized = false;
        if(isInput)
            ((Pierwszy) nodes.get(0)).add_input(w);
    }

    private static void nodesToposort(Wierzchołek w, ArrayList<Wierzchołek> sorted, Ostatni last)
    {
        sorted.add(w);
        if(w.output.size() > 0)
        {
            for(Wierzchołek next: w.output)
               if(next != last)
                    Circuit.nodesToposort(next, sorted, last);
        }
        else
        {
            ArrayList<Integer> out_order = last.extend_output(w.outputSize());
            w.output.add(last);
            w.out_order = out_order;
        }
    }

    private void optimize()
    {
        ArrayList<Wierzchołek> sorted = new ArrayList<Wierzchołek>();
        Circuit.nodesToposort(nodes.get(0), sorted, last);
        nodes = sorted;
    }

    public ArrayList<Integer> execute(ArrayList<Integer> input)
    {
        if(nodes.size() == 1)
            return input;
        if(!isOptimized)
            optimize();
        
        for(int i = 0; i < input.size(); i++)
            nodes.get(0).register(input.get(i), i);
        
        for(Wierzchołek w : nodes)
            w.execute();

        return last.getOutput();
    }

    public Circuit()
    {
        nodes = new ArrayList<Wierzchołek>();
        nodes.add(new Pierwszy());
        last = new Ostatni();
    }

    public int depth()
    {
        if(nodes.size() == 0)
            return 0;
        
        int depth = 1;
        Wierzchołek w = nodes.get(0);
        while(w.output.size() > 0)
        {
            depth++;
            w = w.output.get(0);
        }
        return depth;

    }
}

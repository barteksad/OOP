package src;

import java.util.ArrayList;

public class Wierzchołek 
{
    private Bramka gate;
    protected ArrayList<Integer> input;
    protected ArrayList<Wierzchołek> output;
    protected ArrayList<Integer> out_order;

    public void execute()
    {
        ArrayList<Integer> out = gate.execute(input);
        for(int i = 0; i < out.size(); i++)
            if(output.size() == 1)
                output.get(0).register(out.get(i), out_order.get(i));
            else
                output.get(i).register(out.get(i), out_order.get(i));

    }

    protected void register(int value, int index)
    {
        input.set(index, value);
    }

    public Wierzchołek(Bramka gate, ArrayList<Wierzchołek> output,ArrayList<Integer> out_order)
    {
        assert(gate.outputSize() == output.size());
        this.gate = gate;
        this.output = output;
        this.out_order = out_order;

        this.input = new ArrayList<Integer>();
        for(int i = 0; i < gate.inputSize(); i++)
            input.add(0);
    }

    public Wierzchołek(Bramka gate)
    {
        this.gate = gate;
        this.output = new ArrayList<Wierzchołek>();

        this.input = new ArrayList<Integer>();
        for(int i = 0; i < gate.inputSize(); i++)
            input.add(0);
    }

    public Wierzchołek()
    {
        input = new ArrayList<Integer>();
        output = new ArrayList<Wierzchołek>();
        out_order = new ArrayList<Integer>();
    }

    public int inputSize()
    {
        return input.size();
    }

    public int outputSize()
    {
        return gate.outputSize();
    }
}

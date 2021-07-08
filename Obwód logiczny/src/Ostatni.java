package src;

import java.util.ArrayList;

public class Ostatni extends Wierzchołek
{
    private ArrayList<Integer> out;

    @Override
    public void register(int value, int index)
    {
        out.set(index, value);
    }

    public ArrayList<Integer> getOutput()
    {
        return out;
    }

    public ArrayList<Integer> extend_output(int size)
    {
        ArrayList<Integer> out_order = new ArrayList<Integer>();
        int index = out.size();

        while(size-- > 0)
        {
            out.add(0);
            out_order.add(index++);
        }

        return out_order;
    }

    public Ostatni()
    {
        out = new ArrayList<Integer>();
    }
}

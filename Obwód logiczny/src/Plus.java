package src;

import java.util.ArrayList;

public class Plus extends Bramka
{
    public Plus()
    {
        super(2, 1);
    }

    @Override
    public ArrayList<Integer> execute(ArrayList<Integer> in)
    {
        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(in.get(0) + in.get(1));
        return out;
    }
}

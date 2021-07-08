package src;

import java.util.ArrayList;

public class Or extends Bramka
{
    public Or(int inputSize)
    {
        super(inputSize, 1);
    }

    @Override
    public ArrayList<Integer> execute(ArrayList<Integer> in)
    {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i: in)
            if(i == 1)
            {
                out.add(1);
                return out; 
            }
        out.add(0);
        return out;
    }
}

package src;
public class Pierwszy extends Wierzchołek
{
    @Override
    public void execute()
    {
        for(int i = 0; i < input.size(); i++)
            output.get(i).register(input.get(i), out_order.get(i));
    }

    @Override
    protected void register(int value, int index)
    {
        input.set(index, value);
    }

    public void add_input(Wierzchołek w)
    {
        for(int i = 0; i < w.inputSize(); i++)
        {
            input.add(0);
            output.add(w);
            out_order.add(i);
        }
    }
}

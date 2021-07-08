package src;

import java.util.ArrayList;

public abstract class Bramka 
{
    public abstract ArrayList<Integer> execute(ArrayList<Integer> in);
    private int inputSize;
    private int outputSize;

    public Bramka(int inputSize, int outputSize)
    {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
    }

    protected int inputSize()
    {
        return inputSize;
    }

    protected int outputSize()
    {
        return outputSize;
    }
}

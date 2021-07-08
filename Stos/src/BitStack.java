import java.util.ArrayList;

public class BitStack implements Stack
{
    private ArrayList<Integer> tab;
    
    public BitStack()
    {
        tab = new ArrayList<Integer>();
    }

    public int head()
    {
        if(tab.size() == 0)
            System.out.println("Stack underflow!");
        else
            return tab.get(tab.size() - 1);
        return -1;
    }

    public void push(int x)
    {
        tab.add(x);
    }

    public int pop()
    {
        if(tab.size() == 0)
            System.out.println("Stack underflow!");
        else
            return tab.remove(tab.size() - 1);
        return -1;
    }
    
    public void or()
    {
        if(tab.size() < 2 )
            System.out.println("Stack underflow!");
        else
        {
            int a = tab.remove(tab.size() - 1);
            int b = tab.remove(tab.size() - 1);
            tab.add(a | b);
        }
    }

    public void and()
    {
        if(tab.size() < 2 )
            System.out.println("Stack underflow!");
        else
        {
            int a = tab.remove(tab.size() - 1);
            int b = tab.remove(tab.size() - 1);
            tab.add(a & b);
        }
    }

    public void xor()
    {
        if(tab.size() < 2 )
            System.out.println("Stack underflow!");
        else
        {
            int a = tab.remove(tab.size() - 1);
            int b = tab.remove(tab.size() - 1);
            tab.add(a ^ b);
        }
    }

    public void complement()
    {
        if(tab.size() == 0 )
            System.out.println("Stack underflow!");
        else
        {
            int a = tab.remove(tab.size() - 1);
            tab.add(~a);
        }
    }
}

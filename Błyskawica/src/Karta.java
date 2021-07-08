public class Karta 
{
    private int index;
    private static String[] figury = {"Walet", "Dama", "Król", "As"}; 
    private static String[] kolory = {"trefl", "karo", "kier", "pik"}; 
    public Karta(int index)
    {
        this.index = index; 
    }

    public static int porównaj(Karta lhs, Karta rhs)
    {
        if(lhs.index % 13 < rhs.index % 13)
            return -1;
        else if(lhs.index % 13 == rhs.index % 13)
        {
            if(lhs.index < rhs.index)
                return -1;
            else
                return 1;
        }
        else
            return 1;
    }

    @Override
    public String toString()
    {
        if(index % 13 < 9)
            return (index % 13 + 2) + " " + Karta.kolory[index / 13];
        else
            return Karta.figury[(index % 13 - 9)] +  " " + Karta.kolory[index / 13];
    }
    
}

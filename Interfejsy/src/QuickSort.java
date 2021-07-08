package src;

import static org.junit.Assume.assumeTrue;

import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sortable<T> 
{
    private void swap(List<T> acc, int a, int b)
    {
        T temp = acc.get(a);
        acc.set(a, acc.get(b));
        acc.set(b, temp);
    }
    
    private void qSort(List<T> acc, int a, int b, int order)
    {
        if(a >= b )
            return;

        T pivot = acc.get(b - 1);
        int bound = a;

        for(int j = a; j < b; j ++)
            if(acc.get(j).compareTo(pivot) * order < 0)
                swap(acc, bound++, j);
        
        swap(acc, bound, b - 1);
        qSort(acc, a, bound, order);
        qSort(acc, bound + 1, b, order);
    }

    @Override
    public List<T> sort(List<T> a, boolean ascending) 
    {
        int order = ascending ? 1 : -1;
        List<T> acc = null;
                
        try
        {
            acc = a.getClass().getConstructor().newInstance();
        }catch(Exception e)
        {
            System.out.println(e);
        }

        for(T i: a)
            acc.add(i);

        qSort(acc, 0, a.size(), order);
        return acc;
    }
}

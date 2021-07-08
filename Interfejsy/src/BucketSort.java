package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BucketSort<T extends Comparable<T>> implements Sortable<T>
{
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

        Map<T, Integer> buckets;
        if(order == 1)
            buckets = new TreeMap<T, Integer>();
        else
            buckets = new TreeMap<T, Integer>(Collections.reverseOrder());

        for(T i : a)
            buckets.compute(i, (k, v) -> (v == null) ? 1 : v.intValue()+1);

        for(Map.Entry<T, Integer> entry : buckets.entrySet())
            for(int i = 0; i < entry.getValue(); i++)
            {
                // System.out.println(entry);
                acc.add(entry.getKey());
            }
        return acc;
    }
}

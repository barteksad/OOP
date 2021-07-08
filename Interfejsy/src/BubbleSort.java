package src;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sortable<T> 
{
    @Override
    public List<T> sort(List<T> a, boolean ascending) 
    {
        int order = ascending ? 1 : -1;
        List<T> acc = null;
        boolean[] used = new boolean[a.size()];

        try
        {
            acc = a.getClass().getConstructor().newInstance();
        }catch(Exception e)
        {
            System.out.println(e);
        }

        for(int i = 0; i < a.size(); i ++)
        {
            int max_elt_idx = -1;
            for(int j = 0; j < a.size(); j ++)
            {
                if(max_elt_idx == -1 && used[j] == true)
                    continue;
                if(max_elt_idx == -1 && used[j] == false)
                {
                    max_elt_idx = j;
                    continue;
                } 

                if(!used[j])
                    if(a.get(max_elt_idx).compareTo(a.get(j)) * order > 0)
                        max_elt_idx = j;
            }
            acc.add(a.get(max_elt_idx));
            used[max_elt_idx] = true;
        }
        return acc;
    }
}

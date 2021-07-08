import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.BubbleSort;
import src.BucketSort;
import src.QuickSort;

public class App {

    public static void main(String[] args) throws Exception 
    {
        // Collections.reverseOrder()
    }

    @Test
    public void bubbleSortTest1()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6));
    
        BubbleSort<Integer> sorter = new BubbleSort<Integer>();
    
        List<Integer> b = sorter.sort(a, true);
    
        Collections.sort(a);
        assertEquals(a, b);
    }

    @Test
    public void bubbleSortTest2()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6, 10,33 ,45, 13112, 2, -10, 45));
    
        QuickSort<Integer> sorter = new QuickSort<Integer>();
    
        List<Integer> b = sorter.sort(a, false);
    
        Collections.sort(a, Collections.reverseOrder());
        assertEquals(a, b);
    }

    @Test
    public void qSortTest1()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6));
    
        QuickSort<Integer> sorter = new QuickSort<Integer>();
    
        List<Integer> b = sorter.sort(a, true);
    
        Collections.sort(a);
        assertEquals(a, b);
    }

    @Test
    public void qSortTest2()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6, 10,33 ,45, 13112, 2, -10, 45));
    
        QuickSort<Integer> sorter = new QuickSort<Integer>();
    
        List<Integer> b = sorter.sort(a, true);
    
        Collections.sort(a);
        assertEquals(a, b);
    }

    @Test
    public void qSortTest3()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6, 10,33 ,45, 13112, 2, -10, 45));
    
        QuickSort<Integer> sorter = new QuickSort<Integer>();
    
        List<Integer> b = sorter.sort(a, false);
    
        Collections.sort(a, Collections.reverseOrder());
        assertEquals(a, b);
    }


    @Test
    public void bucketSort1()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6, 10,33 ,45, 13112, 2, -10, 45));
    
        BucketSort<Integer> sorter = new BucketSort<Integer>();
    
        List<Integer> b = sorter.sort(a, false);
    
        Collections.sort(a, Collections.reverseOrder());
        assertEquals(a, b);
    }

    @Test
    public void bucketSort2()
    {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(51,275,33,4,45,6, 10,33 ,45, 13112, 2, -10, 45));
    
        BucketSort<Integer> sorter = new BucketSort<Integer>();
    
        List<Integer> b = sorter.sort(a, true);
    
        Collections.sort(a);
        assertEquals(a, b);
    }
}

package src;


import java.util.List;

public interface Sortable<T>
{
    List<T> sort(List<T> a, boolean ascending);
}
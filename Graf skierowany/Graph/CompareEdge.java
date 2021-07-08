package Graph;
import java.util.*;

public class CompareEdge implements Comparator<Edge>
{
    public int compare(Edge lhs, Edge rhs)
    {
        return lhs.koszt() - rhs.koszt();
    }
}


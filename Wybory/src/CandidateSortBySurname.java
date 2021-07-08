import java.util.Comparator;

public class CandidateSortBySurname implements Comparator<Candidate> {
    
    public int compare(Candidate lhs, Candidate rhs)
    {
        return lhs.surname().compareTo(rhs.surname());
    }
}

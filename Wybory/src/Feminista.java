import java.lang.invoke.VolatileCallSite;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Feminista extends Voter {

    @Override
    public Candidate voting_method(Set<Candidate> all)
    {
        Queue<Candidate> womens = new PriorityQueue<Candidate>(new CandidateSortBySurname());
        for(Candidate c: all)
            if(c.sex() == 1)
                womens.add(c);

        if(womens.size() == 0)
            return null;    
        else
            return womens.poll();
    }

}

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Election {

    private HashMap<Candidate, Integer> Candidates;
    private int votes_count;
    private int invalid_votes; 

    public Election(List<Candidate> list)
    {
        this.Candidates = new HashMap<Candidate, Integer>();
        for(Candidate c: list)
            this.Candidates.put(c, 0);
        
        this.votes_count =0;
        this.invalid_votes = 0;
    }

    public void CarryOutElection(List<Voter> voters)
    {
        Set<Candidate> all = Candidates.keySet();
        for(Voter voter : voters)
        {
            votes_count++;
            Candidate choosen = voter.vote(all);
            if(choosen == null)
            {
                invalid_votes++;
                continue;
            }

            int tmp = Candidates.get(choosen);
            Candidates.put(choosen, ++tmp);
        }
    }

    public String giveResults()
    {
        Map<Integer, Candidate> sorter = new HashMap<Integer, Candidate>();

        for(Entry<Candidate, Integer> entry : Candidates.entrySet())
            sorter.put(entry.getValue(), entry.getKey());
        StringBuilder result = new StringBuilder();
        
        for(Entry<Integer, Candidate> entry : sorter.entrySet())
        {
            result.append(entry.getValue() + " ");
            result.append(entry.getKey() + " ");
            result.append(Math.round(entry.getKey() * 100 / votes_count) + "%");
            result.append("\n");
        }

        result.append("głosy nieważne: " + invalid_votes + " " + Math.round(invalid_votes * 100 / votes_count) + "%\n");

        return result.toString();
    }
}

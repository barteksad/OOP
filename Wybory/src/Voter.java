import java.util.Set;

public abstract class Voter {

    protected boolean has_voted;

    public Voter()
    {
        has_voted = false;
    }

    public boolean has_voted()
    {
        return has_voted;
    }

    public abstract Candidate voting_method(Set<Candidate> all);

    public Candidate vote(Set<Candidate> all)
    {
        has_voted = true;
        return voting_method(all);
    }
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Partyjniak extends Voter {

    private static Random r = new Random();

    private String party_name;

    public Partyjniak(String party_name)
    {
        this.party_name = party_name;
    }

    @Override
    public Candidate voting_method(Set<Candidate> all) {
        if(r.nextDouble() > 0.5)
            return null;
        
        ArrayList<Candidate> party = new ArrayList<Candidate>();
        for(Candidate c: all)
            if(c.party_name().equals(party_name))
                party.add(c);
        
        if(party.size() == 0)
            return null;
        return party.get(r.nextInt(party.size()));
    }
}

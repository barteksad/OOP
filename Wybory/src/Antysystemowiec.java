import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Antysystemowiec extends Voter{

    private static Random r = new Random();

    @Override
    public Candidate voting_method(Set<Candidate> all) {
        if(r.nextDouble() > 0.5)
            return null;
        
        ArrayList<Candidate> nonpartisans = new ArrayList<Candidate>();
        for(Candidate c: all)
            if(c.party_name().equals("nopartisan"))
                nonpartisans.add(c);
        
        if(nonpartisans.size() == 0)
            return null;
        else
            return nonpartisans.get(r.nextInt(nonpartisans.size()));
    }
}

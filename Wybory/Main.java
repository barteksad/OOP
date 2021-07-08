import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import org.junit.jupiter.api.Test;
public class Main 
{
    static private String[] parties = {"A","B","X","Y"};
    public static void main(String [] args)
    {
        Candidate a = new Candidate("A", "aaa", "Nowak", 0);
        Candidate b = new Candidate("B", "bbbb", "Piątkowski", 1);
        Candidate c = new Candidate("X", "ccc", "Kowalski", 0);
        Candidate e = new Candidate("X", "e", "Ewa", 1);
        Candidate g = new Candidate("Y", "g", "Ziutek", 0);
        
        Election election = new Election(Arrays.asList(a, b, c, e, g));

        Random r = new Random();
        ArrayList<Voter> voters = new ArrayList<Voter>();

        for(int i = 0; i < 10_000; i++)
        {
            int x = r.nextInt(4);

            switch(x)
            {
                case 0:
                    voters.add(new Znudzony());
                    break;
                case 1:
                    voters.add(new Feminista());
                    break;
                case 2:
                    voters.add(new Partyjniak(parties[r.nextInt(parties.length)]));
                    break;
                case 3:
                    voters.add(new Antysystemowiec());
                    break;
            }
        }
        GsonBuilder gson = new GsonBuilder();
        election.CarryOutElection(voters);
        gson.registerTypeAdapter(Candidate.class, new CandidatSerializer());
        System.out.println(gson.create().toJson(election));
    }    

    @Test
    void test1()
    {
        Candidate a = new Candidate("A", "a", "aaaaa", 0);
        Candidate b = new Candidate("B", "b", "bbbbb", 1);
        Candidate c = new Candidate("X", "c", "ccccc", 0);
        Candidate d = new Candidate("X", "d", "ddddd", 1);
        Candidate e = new Candidate("X", "e", "eeeee", 0);
        Candidate f = new Candidate("Y", "f", "fffff", 1);
        Candidate g = new Candidate("Y", "g", "ggggg", 0);
        
        Election election = new Election(Arrays.asList(a, b, c, d, e, f, g));

        Random r = new Random();
        ArrayList<Voter> voters = new ArrayList<Voter>();

        for(int i = 0; i < 10_000; i++)
        {
            int x = r.nextInt(4);

            switch(x)
            {
                case 0:
                    voters.add(new Znudzony());
                    break;
                case 1:
                    voters.add(new Feminista());
                    break;
                case 2:
                    voters.add(new Partyjniak(parties[r.nextInt(parties.length)]));
                    break;
                case 3:
                    voters.add(new Antysystemowiec());
                    break;
            }
        }

        election.CarryOutElection(voters);
        System.out.println(election.giveResults());

        election.CarryOutElection(voters);
    }

    @Test
    void test2()
    {
        Candidate a = new Candidate("A", "aaa", "Nowak", 0);
        Candidate b = new Candidate("B", "bbbb", "Piątkowski", 1);
        Candidate c = new Candidate("X", "ccc", "Kowalski", 0);
        Candidate e = new Candidate("X", "e", "Ewa", 1);
        Candidate g = new Candidate("Y", "g", "Ziutek", 0);
        
        Election election = new Election(Arrays.asList(a, b, c, e, g));

        Random r = new Random();
        ArrayList<Voter> voters = new ArrayList<Voter>();

        for(int i = 0; i < 10_000; i++)
        {
            int x = r.nextInt(4);

            switch(x)
            {
                case 0:
                    voters.add(new Znudzony());
                    break;
                case 1:
                    voters.add(new Feminista());
                    break;
                case 2:
                    voters.add(new Partyjniak(parties[r.nextInt(parties.length)]));
                    break;
                case 3:
                    voters.add(new Antysystemowiec());
                    break;
            }
        }

        election.CarryOutElection(voters);
        System.out.println(election.giveResults());

        election.CarryOutElection(voters);
    }

    @Test
    void test3()
    {
        Candidate a = new Candidate("A", "aaa", "Nowak", 0);
        Candidate b = new Candidate("B", "bbbb", "Piątkowski", 1);
        Candidate c = new Candidate("X", "ccc", "Kowalski", 0);
        Candidate e = new Candidate("X", "e", "Ewa", 1);
        Candidate g = new Candidate("Y", "g", "Ziutek", 0);
        
        Election election = new Election(Arrays.asList(a, b, c, e, g));

        Random r = new Random();
        ArrayList<Voter> voters = new ArrayList<Voter>();

        for(int i = 0; i < 10_000; i++)
        {
            int x = r.nextInt(4);

            switch(x)
            {
                case 0:
                    voters.add(new Znudzony());
                    break;
                case 1:
                    voters.add(new Feminista());
                    break;
                case 2:
                    voters.add(new Partyjniak(parties[r.nextInt(parties.length)]));
                    break;
                case 3:
                    voters.add(new Antysystemowiec());
                    break;
            }
        }

        election.CarryOutElection(voters);
        // System.out.printlngson(election));
        System.out.println(election.giveResults());
    }
}

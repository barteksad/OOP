public class Candidate{

    private String party_name;
    private String name;
    private String surname;
    private int sex; // 0 man 1 woman
    
    public Candidate(String party_name, String name, String surname, int sex) {
        this.party_name = party_name;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public String party_name()
    {
        return party_name;
    }

    public String name()
    {
        return name;
    }

    public int sex()
    {
        return sex;
    }

    public String surname()
    {
        return surname;
    }

    @Override
    public String toString()
    {
        return surname.toUpperCase() + " " + name;
    }
}
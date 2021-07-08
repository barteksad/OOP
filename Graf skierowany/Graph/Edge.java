package Graph;

public class Edge implements Cloneable
{
    private Vertex początek;
    private Vertex koniec;
    private int koszt;

    public Edge(Vertex koniec, int koszt)
    {
        this.koniec = koniec;
        this.koszt = koszt;
    }

    protected Object clone()
    {
      Edge e = null;
      try
      {
        e = (Edge) super.clone();
        e.początek = null;
        e.koniec = (Vertex) koniec.clone();
        return e;
      }
      catch (CloneNotSupportedException ee)
      {
        ee.printStackTrace();
      }
      return e;
    }

    public Vertex koniec()
    {
        return this.koniec;
    }

    public Vertex początek()
    {
        return this.początek;
    }

    public int koszt()
    {
        return this.koszt;
    }

    public void ustaw_początek(Vertex v)
    {
        this.początek = v;
    }

    
}

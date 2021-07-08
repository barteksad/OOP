package Graph;
import java.util.*;

public class Vertex implements Cloneable
{
  public int numer; 
  private ArrayDeque <Edge> sąsiedzi;
  

  public void dodaj_sąsiada(Vertex v, int koszt)
  {
    for(Edge e: sąsiedzi)
      if(e.koniec() == v)
        return;
    this.sąsiedzi.add(new Edge(v, koszt));
  }

  public void usuń_sąsiada(Vertex v)
  {
    for(Edge i: this.sąsiedzi)
      if (i.koniec() == v)
        this.sąsiedzi.remove(i);
  }

  public Vertex(int numer)
  {
    this.numer = numer;
    this.sąsiedzi = new ArrayDeque<Edge>();
  }

  protected Object clone()
  {
    Vertex v = null;
    try
    {
      v = (Vertex) super.clone();
      v.numer = numer;
      v.sąsiedzi = (ArrayDeque<Edge>) sąsiedzi.clone();
      return v;
    }
    catch (CloneNotSupportedException e)
    {
      e.printStackTrace();
    }
    return v;
  }

  public ArrayDeque<Edge> sąsiedzi()
  {
    return this.sąsiedzi;
  }

  public String toString()
  {
      return "" + this.numer;
  }
}
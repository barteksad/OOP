package Graph;
import java.util.*;

public class Graph implements Cloneable{   

  private ArrayDeque<Vertex> wierzchołki;

  public Graph()
  {
    this.wierzchołki = new ArrayDeque<Vertex>();
  }

  protected Object clone()
  {
    Graph g = null;
    try
    {
      g = (Graph) super.clone();
      g.wierzchołki = new ArrayDeque<Vertex>();
      g.wierzchołki = new ArrayDeque<Vertex>();
      Iterator<Vertex> iterator = wierzchołki.iterator();
      while(iterator.hasNext())
        g.wierzchołki.add((Vertex) iterator.next().clone());  
      return g;
    }
    catch (CloneNotSupportedException e)
    {
      e.printStackTrace();
    }
    return g;
  }

  Vertex wierzchołki(int n) 
  {
    for(Vertex v : this.wierzchołki)
       if (v.numer == n)
        return v;
    return null;
  }

  public void dodaj_wierchołek(int numer)
  {
    Vertex v = new Vertex(numer);
    wierzchołki.add(v);
  }
  
   public void dodaj_krawędź(int a, int b, int koszt)
   {
     Vertex v_a, v_b;
     v_a = this.wierzchołki(a);
     v_b = this.wierzchołki(b);
     v_a.dodaj_sąsiada(v_b, koszt);
     v_b.dodaj_sąsiada(v_a, koszt);
  }
    
    
    public void usuń_krawędź(int a, int b)
    {
     Vertex v_a, v_b;
     v_a = this.wierzchołki(a);
     v_b = this.wierzchołki(b);
     v_a.usuń_sąsiada(v_b);
     v_b.usuń_sąsiada(v_a);
    }
    
   public boolean czy_w_cyklu(int w)
   {
      Graph g = (Graph) this.clone();
      Vertex początkowy = g.wierzchołki(w);
      Set<Integer> odwiedzone = new HashSet<Integer>();
      Queue<Vertex> do_sprawdzenia = new LinkedList<Vertex>();
      do_sprawdzenia.add(początkowy);

      while(!do_sprawdzenia.isEmpty())
      {
        Vertex aktualny = do_sprawdzenia.poll();
        for(Edge e : aktualny.sąsiedzi())
        {
          if (e.koniec() == początkowy)
            return true;
          if (!odwiedzone.contains(e.koniec().numer))
          {
            g.usuń_krawędź(aktualny.numer, e.koniec().numer);
            do_sprawdzenia.add(e.koniec());
          }
          odwiedzone.add(aktualny.numer);
        }
      }

      return false;
   }

   public String najkrótsza_ścierzka(int a, int b)
   {
     Vertex początkowy = this.wierzchołki(a);
     Vertex końcowy = this.wierzchołki(b);
     Map<Vertex, Integer> koszty = new HashMap<Vertex, Integer>();
     Map<Vertex, Vertex> ścierzka = new HashMap<Vertex, Vertex>();
     Queue<Vertex> do_sprawdzenia = new LinkedList<Vertex>();

     koszty.put(this.wierzchołki(a), 0);
     do_sprawdzenia.add(początkowy);

     while(!do_sprawdzenia.isEmpty())
     {
      Vertex aktualny = do_sprawdzenia.poll();
      int aktualny_koszt = koszty.get(aktualny);

      for(Edge e : aktualny.sąsiedzi())
      {
        if (koszty.containsKey(e.koniec()))
        {
          int koszt = koszty.get(e.koniec());
          if (koszt > aktualny_koszt + e.koszt())
          {
            koszty.replace(e.koniec(), aktualny_koszt + e.koszt());
            ścierzka.replace(e.koniec(), aktualny);
            do_sprawdzenia.add(e.koniec());
          }
        }
        else
        {
          koszty.put(e.koniec(), aktualny_koszt + e.koszt());
          ścierzka.put(e.koniec(), aktualny);
          do_sprawdzenia.add(e.koniec());
        }
      }
     }

     String wynik = "(" + koszty.get(końcowy) + ")";
     while(końcowy.numer != początkowy.numer)
     {
      wynik = końcowy.numer + " " + wynik;
      końcowy = ścierzka.get(końcowy);
     }
     return początkowy.numer + " " + wynik;
   }

   private boolean sprawdź_czy_istnieje_cykl_eulera()
   {
      for(Vertex v: this.wierzchołki)
        if( v.sąsiedzi().size() % 2 == 1)
          return false;

      return true;
   }

   private static void DFS(Stack<Vertex> acc, Vertex v, Graph g)
   {
      while(!v.sąsiedzi().isEmpty())
      {
        Edge e = v.sąsiedzi().getFirst();
        g.usuń_krawędź(v.numer, e.koniec().numer);
        DFS(acc, e.koniec(), g);
      }
      acc.add(v);
   }

   public String znajdź_cykl_eulera()
   {
      if(!this.sprawdź_czy_istnieje_cykl_eulera())
        return "";

      Graph g = (Graph) this.clone();
      Stack<Vertex> cykl = new Stack<Vertex>();
      Graph.DFS(cykl, g.wierzchołki.getFirst(), g);

      String wynik = "";
      while(!cykl.isEmpty())
        wynik = wynik + " " + cykl.pop().numer;
      return wynik.substring(1);
   }  
    
    public Graph minimalne_drzewo_rozpinające()
    {
      Graph g = new Graph();
      int ile_do_dodania_krawędzi = this.wierzchołki.size();

      ArrayList<Edge> krawędzie = new ArrayList<Edge>();
      for(Vertex v: this.wierzchołki)
        for(Edge e: v.sąsiedzi())
        {
          Edge ne = (Edge) e.clone();
          ne.ustaw_początek(v);
          krawędzie.add(ne);
        }
      krawędzie.sort(new CompareEdge());

      for(int i = 0; i < krawędzie.size(); i++)
      {
        if(ile_do_dodania_krawędzi == 0)
          break;
        Edge aktualna = krawędzie.get(i);
        int pocz_num = aktualna.początek().numer;
        int kon_num = aktualna.koniec().numer;
        int koszt = aktualna.koszt();

        if(g.wierzchołki(pocz_num) == null)
          g.dodaj_wierchołek(pocz_num);

        if(g.wierzchołki(kon_num) == null)
          g.dodaj_wierchołek(kon_num);
        g.dodaj_krawędź(pocz_num, kon_num, koszt);
        ile_do_dodania_krawędzi--;
        if(g.czy_w_cyklu(pocz_num))
        {
          g.usuń_krawędź(pocz_num, kon_num);
          ile_do_dodania_krawędzi++;
        }
      }

      return g;
    }
    
    @Override
    public String toString()
    {
      StringBuilder str = new StringBuilder();
      str.append("skąd/gdzie/(koszt)");
      for(Vertex v: this.wierzchołki)
      {
        str.append("\n"); 
        str.append(v + ":");
        for(Edge e: v.sąsiedzi())
          str.append(" " + e.koniec() + " (" + e.koszt() + "),");
      }
      return str.toString();
    }
}

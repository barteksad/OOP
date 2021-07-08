public class PunktSzczepeiń 
{
    
    private Szczepionka szczepionka;
    private int przepustowość;
    private int adres;
    private int najbliższy_wolny_termin;
    private int ile_w_najbliższym_wolnym;
    
    public PunktSzczepeiń(Szczepionka szczepionka, int przepustowość, int adres, int najbliższy_wolny_termin,
            int ile_w_najbliższym_wolnym)
    {
        this.szczepionka = szczepionka;
        this.przepustowość = przepustowość;
        this.adres = adres;
        this.najbliższy_wolny_termin = najbliższy_wolny_termin;
        this.ile_w_najbliższym_wolnym = ile_w_najbliższym_wolnym;
    }

    public Szczepionka szczepionka()
    {
        return szczepionka;
    }

    public int adres()
    {
        return adres;
    }

    public int najbliższy_wolny_termin()
    {
        return najbliższy_wolny_termin;
    }

    public int zarejestruj_na_najbliższy_wolny()
    {
        int termin = najbliższy_wolny_termin;
        ile_w_najbliższym_wolnym++;
        if(ile_w_najbliższym_wolnym == przepustowość)
        {
            ile_w_najbliższym_wolnym = 0;
            najbliższy_wolny_termin++;
        }
        return termin;
    }

    public int ile_zaszczepionych()
    {
        return najbliższy_wolny_termin*przepustowość + ile_w_najbliższym_wolnym;
    }
}

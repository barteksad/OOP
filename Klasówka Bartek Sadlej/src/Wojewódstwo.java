import java.util.ArrayList;

public class Wojewódstwo extends Region
{
    private int pierwsza_cyfra_kodu;

    public Wojewódstwo(ArrayList<PunktSzczepeiń> punkty_szczepień)
    {
        super(punkty_szczepień);
        this.pierwsza_cyfra_kodu = punkty_szczepień.get(0).adres() % 10_000;
    }

    @Override
    public boolean czy_w_tym_regionie(Pacjent p)
    {
        return p.adres() % 10_000 == pierwsza_cyfra_kodu;
    }
}

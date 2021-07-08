package pracownicy;

import przesyłalne.*;
import sprzęt.Linia;

public class KierownikLini extends Pracownik {

    private int adres_dyrektora;
    private int ilu_pracowników;
    private Linia linia;

    @Override
    public Przesyłka czekajOdbierz() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void pracuj() {
        while (true) {

            float ocena = 0;
            Przesyłka przesyłki[] = new Przesyłka[ilu_pracowników];

            for (int i = 0; i < ilu_pracowników; i++) {
                przesyłki[i] = czekajOdbierz();
                if (przesyłki[i].getClass().isInstance(KoniecPracy.class))
                    return;
                if (przesyłki[i].getClass().isInstance(WyślijOceneIOpis.class)) {
                    ocena += ((WyślijOceneIOpis) przesyłki[i]).getOcena();
                }
            }

            ocena = ocena / (float) ilu_pracowników;
            if (ocena > 0.95) {
                PrzepisNaBajaderke przepis = stwórzPrzepis(przesyłki);
                wyślij(adres_dyrektora, new WyślijPrzepis(adres, przepis));
            }
            if (ocena > 0.75) {
                for (Przesyłka przesyłka : przesyłki)
                    wyślij(przesyłka.getAdresNadawcy(), new PolecenieModyfikacji(adres));
            } else {
                for (int i = 0; i < (int) Math.round(1.0 / (ocena + Float.MIN_NORMAL)); i++)
                    linia.dodaj_losowego_pracownika();
            }
        }
    }

    public PrzepisNaBajaderke stwórzPrzepis(Przesyłka przesyłki[]) {
        return null;
    }

    public boolean czyPrzypominaBajaderke(PrzepisNaBajaderke przepis) {
        return true;
    }

    @Override
    public void wyślij(int adres, Przesyłka przesyłka) {
        // TODO Auto-generated method stub

    }

}

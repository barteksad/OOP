import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import konta.*;
import wyjątki.*;
import zlecenia.Zlecenie;
import zlecenia.ZleceniePrzelewu;

public class PierwszyBankBajtocji {
    
    private Collection<Konto> konta;

    public PierwszyBankBajtocji() {
        konta = new ArrayList<Konto>();
    }

    public void przetworzZleceniaPrzelewu(Collection<ZleceniePrzelewu> zlecenia) {
        for(Zlecenie z : zlecenia)
            z.wykonaj();
    }


    public void koniecMiesiaca()
}

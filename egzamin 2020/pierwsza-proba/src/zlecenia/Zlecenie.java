package zlecenia;

import java.util.Collection;

import konta.Konto;
import wyjątki.WyjątekBanku;

abstract public class Zlecenie {
    
    abstract void wykonaj(Collection<Konto> konta) throws WyjątekBanku;
}

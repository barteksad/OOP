package Czytelnicy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import dane.ZapamiętanaDana;

public class NaTematOstatniejOpowiadający extends Czytelnik{

    private static final String Iterator = null;

    public NaTematOstatniejOpowiadający(ArrayList<ZapamiętanaDana> preferencje) {
        super(preferencje);
    }
    
    @Override 
    public String toString() {
        StringBuilder wypowiedź = new StringBuilder();

        Iterator<Map.Entry<String, ArrayList<ZapamiętanaDana>>> iter = this.zapamiętane_książki.entrySet().iterator(); 
        Map.Entry<String, ArrayList<ZapamiętanaDana>> ostatnia;
        while(iter.hasNext())
            ostatnia = iter.next();

        for(ZapamiętanaDana dana: ostatnia.getValue())
            wypowiedź.append(dana.toString());

        return wypowiedź.toString();
    }
}

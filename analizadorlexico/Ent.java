package analizadorlexico;

import java.util.Hashtable;

public class Ent {
    private Hashtable tabla;
    protected Ent ant;

    public Ent(Ent p){
        tabla = new Hashtable();
        ant = p;
    }
    
    public void put(String s, Simbolo sim){
        tabla.put(s, sim);
    }

    public Simbolo get(String s){
        for(Ent e = this; e != null ; e = e.ant){
            Simbolo encontro =(Simbolo)(e.tabla.get(s));
            if(encontro != null) return encontro;
        }
        return null;
    }

}

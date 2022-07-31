package it.cecksum.hash.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private final Map<String, Object> beans = new HashMap<>();

    public void putBean(String chiave, Object valore) {
        this.beans.put(chiave, valore);
    }

    public Object getBean(String chiave) {
        return this.beans.get(chiave);
    }
}

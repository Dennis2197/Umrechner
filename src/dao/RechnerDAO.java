package dao;

import java.util.HashMap;
import java.util.Map;

public class RechnerDAO {
    public Map<String, Double> unit;
    public RechnerDAO(){
        unit = new HashMap<>();
        unit.put("mm", 0.001);
        unit.put("cm", 0.01);
        unit.put("dm", 0.1);
        unit.put("m", 1.0);
        unit.put("km", 1000.0);
        unit.put("Zoll", 0.0254);
        unit.put("Fuß", 0.3048);
        unit.put("Yard", 0.9144);
        unit.put("Meilen", 1609.34);
    }

    public String[] getUnitString(){
        int i = 0;
        String[] keys = new String[unit.size()];
        for(Map.Entry<String, Double> mapEntry : unit.entrySet()){
            keys[i] = mapEntry.getKey();
            i++;
        }
        return keys;
    }
}


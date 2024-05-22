package dao;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class RechnerDAO {
    private Map<String, Double> lengthUnit;
    private Map<String, Double> weightUnit;
    private String userInput;

    public RechnerDAO() {
        lengthUnit = new HashMap<>();
        lengthUnit.put("mm", 0.001);
        lengthUnit.put("cm", 0.01);
        lengthUnit.put("dm", 0.1);
        lengthUnit.put("m", 1.0);
        lengthUnit.put("km", 1000.0);
        lengthUnit.put("Zoll", 0.0254);
        lengthUnit.put("Fuß", 0.3048);
        lengthUnit.put("Yard", 0.9144);
        lengthUnit.put("Meilen", 1609.34);

        weightUnit = new HashMap<>();
        weightUnit.put("Gramm", 0.001);
        weightUnit.put("Kilogramm", 1.0);
        weightUnit.put("Tonne", 1000.0);
        weightUnit.put("Pfund", 0.453592);
        weightUnit.put("Unze", 0.0283495);
        weightUnit.put("Milligramm", 0.000001);
        weightUnit.put("Mikrogramm", 0.000000001);
        weightUnit.put("ImperialTonne", 1016.0469088);
        weightUnit.put("US Tonne", 907.18474);
        weightUnit.put("Stein", 6.35029318);
    }

    public String[] getlengthUnitString() {
        int i = 0;
        String[] keys = new String[lengthUnit.size()];
        for (Map.Entry<String, Double> mapEntry : lengthUnit.entrySet()) {
            keys[i] = mapEntry.getKey();
            i++;
        }
        return keys;
    }
    public String[] getWeightUnitString() {
        int i = 0;
        String[] keys = new String[weightUnit.size()];
        for (Map.Entry<String, Double> mapEntry : weightUnit.entrySet()) {
            keys[i] = mapEntry.getKey();
            i++;
        }
        return keys;
    }
    public Double getUserInput(){
        String input = userInput;
        try{
            Double inputDouble = Double.parseDouble(input);
            return inputDouble;
        } catch (NumberFormatException e){
            return null;
        }
    }
    public void setUserInput(String userInput){
        this.userInput = userInput;
    }

    public Map<String, Double> getLengthUnit() {
        return lengthUnit;
    }

    public Map<String, Double> getWeightUnit() {
        return weightUnit;
    }
}

//nice
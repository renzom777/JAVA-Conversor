/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public enum Temperaturas {
    
    //unidad de referencia: grados celsius
    
    Kelvin (-272.15),
    Farenheit (-17.22);
    
    private double cambio;
    
    Temperaturas (double cambio) {
        this.cambio = cambio;
    }
    
    public static String REFERENCIA = "Celsius"; 
    
    public static String[] enums() {
        List<String> enums = new ArrayList<>();
        Temperaturas temperaturas[] = Temperaturas.values();
        for (Temperaturas temperatura : temperaturas) {
            enums.add(temperatura.toString());
        }
        String array[] = new String[enums.size()];
        array = enums.toArray(array);
        return array;
        
    }
    
    public double getCambio() {
        return cambio;
    }
    
}

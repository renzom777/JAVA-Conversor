/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public enum Monedas {
    
    //unidad de referencia: pesos argentinos
    
    Dolar (200),
    Euro (210.76),
    Libra (236.72),
    Yen (1.46),
    Won (0.15);
    
    private double cambio;
    public static String REFERENCIA = "Pesos"; 
    
    Monedas(double cambio) {
        this.cambio = cambio;
    }
    
    public static String[] enums() {
        List<String> enums = new ArrayList<>();
        Monedas monedas[] = Monedas.values();
        for (Monedas moneda : monedas) {
            enums.add(moneda.toString());
        }
        String array[] = new String[enums.size()];
        array = enums.toArray(array);
        return array;
        
    }
    
    public double getCambio() {
        return cambio;
    }
    
}

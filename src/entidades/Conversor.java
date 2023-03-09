/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import enums.Monedas;

public class Conversor {
       
   public double convertirDesdeUnidadDeReferencia(double tipoDeCambio, double aConvertir) {
        
        return aConvertir / tipoDeCambio;
        
    }

    public double convertirAUnidadDeReferencia(double tipoDeCambio, double aConvertir) {
        
        return aConvertir * tipoDeCambio;
        
    }
    
}

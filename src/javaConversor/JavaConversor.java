/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaConversor;

import entidades.Conversor;
import enums.Monedas;
import enums.Temperaturas;
import javax.swing.JOptionPane;

public class JavaConversor {

    public static void main(String[] args) {

        mostrarMenu();

    }

    public static void mostrarMenu() {
        
        String opciones[] = new String[2];
        opciones[0] = "Moneda";
        opciones[1] = "Temperatura";

        String seleccion = (String) JOptionPane.showInputDialog(null, "¿Cuál conversor desea utilizar?", "CONVERSOR", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case "Moneda":
                String monedas[] = Monedas.enums();
                String referenciaMoneda = Monedas.REFERENCIA;
                String modoMoneda = seleccionarModo(referenciaMoneda);
                String unidadSeleccionadaMoneda = seleccionOpciones(modoMoneda, monedas, referenciaMoneda);
                double valorIngresadoMoneda = ingresarValor();
                double relacionDeCambioMoneda = Monedas.valueOf(unidadSeleccionadaMoneda).getCambio();
                convertirYMostrar(modoMoneda, referenciaMoneda, unidadSeleccionadaMoneda, valorIngresadoMoneda, relacionDeCambioMoneda);
                break;
            case "Temperatura":
                String temperaturas[] = Temperaturas.enums();
                String referenciaTemperatura = Temperaturas.REFERENCIA;
                String modoTemperatura = seleccionarModo(referenciaTemperatura);
                String unidadSeleccionadaTemperatura = seleccionOpciones(modoTemperatura, temperaturas, referenciaTemperatura);
                double valorIngresadoTemperatura = ingresarValor();
                double relacionDeCambioTemperatura = Temperaturas.valueOf(unidadSeleccionadaTemperatura).getCambio();
                convertirYMostrar(modoTemperatura, referenciaTemperatura, unidadSeleccionadaTemperatura, valorIngresadoTemperatura, relacionDeCambioTemperatura);
                break;
        }

    }

    public static void convertirYMostrar(String modo, String referencia, String unidadSeleccionada, double aConvertir, double cambio) {

        Conversor conversor = new Conversor();

        if (modo.equals("De " + referencia + " a otra unidad")) {
            double conversion = conversor.convertirDesdeUnidadDeReferencia(cambio, aConvertir);
            JOptionPane.showMessageDialog(null, aConvertir + " " + referencia + " son " + conversion + " " + unidadSeleccionada);
        } else {
            double conversion = conversor.convertirAUnidadDeReferencia(cambio, aConvertir);
            JOptionPane.showMessageDialog(null, aConvertir + " " + unidadSeleccionada + " son " + conversion + " " + referencia);
        }
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
        
        if(opcionSeleccionada == 0) {
            mostrarMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
        }
    }

    public static double ingresarValor() {
        try {
            String valorString = (String) JOptionPane.showInputDialog("Ingrese valor a convertir");
            return Double.parseDouble(valorString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
            return ingresarValor();
        }

    }

    public static String seleccionOpciones(String modo, String[] opciones, String referencia) {
        if (modo.equals("De " + referencia + " a otra unidad")) {
            return mostrarOpcionesDeConversion(opciones, referencia, "Convertir de " + referencia + " a:");
        } else {
            return mostrarOpcionesDeConversion(opciones, referencia, "Convertir a " + referencia + ":");
        }
    }

    public static String seleccionarModo(String referencia) {
        String opciones[] = new String[2];
        opciones[0] = "De " + referencia + " a otra unidad";
        opciones[1] = "De otra unidad a " + referencia;
        return (String) JOptionPane.showInputDialog(null, "Seleccionar modo", "MODO", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    public static String mostrarOpcionesDeConversion(String[] opciones, String referencia, String titulo) {
        return (String) JOptionPane.showInputDialog(null, titulo, "Menu", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

}

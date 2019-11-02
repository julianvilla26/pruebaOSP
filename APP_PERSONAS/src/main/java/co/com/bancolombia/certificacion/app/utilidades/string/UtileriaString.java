package co.com.bancolombia.certificacion.app.utilidades.string;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.COMA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_UTILIDAD;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.getPlatformCapability;

public class UtileriaString {

    private UtileriaString() {
        throw new IllegalStateException(CLASE_UTILIDAD);
    }

    public static int contarCantidadCaracter(String cadena, char caracter) {
        int posicion;
        int contador = 0;
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) {
            contador++;
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }

    public static String obtenerValorEntero(String cadena) {
        char[] cadenaAux = cadena.toCharArray();
        String valorEntero = "";
        for (int i = 0; i < cadenaAux.length; i++) {
            if (Character.isDigit(cadenaAux[i]) || cadenaAux[i] == COMA) {
                valorEntero += cadenaAux[i];
            }
        }
        return valorEntero;
    }

    public static String darFormato(String valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat asignarFormato = new DecimalFormat("0,000.00", simbolo);
        return asignarFormato.format(Double.parseDouble(valor));
    }

    public static String eliminarTildes(String palabra) {
        palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD);
        palabra = palabra.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return palabra.toUpperCase();
    }

    public static String eliminarCaracter(String palabra, String caracter) {
        String resultado = eliminarTildes(palabra);
        if (resultado.contains(caracter)) {
            return resultado.replace(caracter, "");
        } else {
            return resultado;
        }
    }

    public static int obtenerIteradorEprepago(int iterador) {
        String nombrePlataforma = getPlatformCapability();
        if ("Android".equalsIgnoreCase(nombrePlataforma))
            return iterador;
        else
            return iterador + iterador -1;
    }
}
package co.com.bancolombia.certificacion.app.utilidades.administradores;


import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import org.apache.commons.lang3.StringUtils;

import static co.com.bancolombia.backend.utilidades.constant.ConstantManager.PORCENTAJE;
import static co.com.bancolombia.backend.utilidades.constant.ConstantStringFormat.*;

public class StringManager {

    private StringManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }

    public static String formatoLike(String dato) {
        return String.format(FORMATO_LIKE, PORCENTAJE, dato, PORCENTAJE);
    }

    public static String ultimosCaracteres(String dato, int cantidad) {
        return StringUtils.right(dato, cantidad);
    }

    public static String formatoValorBd(String dato) {
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(StringUtils.remove(dato, "[/.|/,]")));
    }

    public static String formatoValor(String dato) {
        return StringUtils.remove(dato, "[/.|/,]");
    }

    public static String formatoFechaBd(String dato) {
        return StringUtils.right(CEROS6.concat(StringUtils.replace(dato, "/", StringUtils.EMPTY)), 6);
    }

    public static String formatoDocumento(String dato) {
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(dato));
    }

    public static String formatoTarjeta(String dato) {
        return String.format(FORMATO16CEROSIZQ, Long.parseLong(dato));

    }

    public static String formato17Ceros(String dato) {
        dato = formatoValor(dato);
        return  String.format(FORMATO17CEROSIZQ, Long.parseLong(dato));

    }

    public static String formato15Ceros(String dato) {
        dato = formatoValor(dato);
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(dato));
    }

    public static String formatoFondo(String dato) {
        return String.format(FORMATO13CEROSIZQ, Long.parseLong(dato));

    }

    public static String reemplazarModeloDatos(String datosCampos) {
        return StringUtils.remove(datosCampos, "(co.com.bancolombia.backend.modelo.)|<|>|productos.|transversal.|@\\w+").replaceAll(",", "\n").replaceAll("\\[", "[\n").replaceAll("\\]", "\n]");
    }

    public static String getFileName(String fileName) {

        int longitud = fileName.length();
        int intIndex = fileName.indexOf(AdministradorConstante.GUION);
        return fileName.substring(intIndex+1,longitud);
    }
}

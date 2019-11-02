package co.com.bancolombia.certificacion.app.utilidades.administradores;


import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import org.apache.commons.lang3.StringUtils;

import static co.com.bancolombia.backend.utilidades.constant.ConstantManager.PORCENTAJE;
import static co.com.bancolombia.backend.utilidades.constant.ConstantStringFormat.*;

/**
 * The type String manager.
 */
public class StringManager {

    private StringManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }

    /**
     * Formato like string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoLike(String dato) {
        return String.format(FORMATO_LIKE, PORCENTAJE, dato, PORCENTAJE);
    }

    /**
     * Ultimos caracteres string.
     *
     * @param dato     the dato
     * @param cantidad the cantidad
     * @return the string
     */
    public static String ultimosCaracteres(String dato, int cantidad) {
        return StringUtils.right(dato, cantidad);
    }

    /**
     * Formato valor bd string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoValorBd(String dato) {
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(StringUtils.remove(dato, "[/.|/,]")));
    }

    /**
     * Formato valor string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoValor(String dato) {
        return StringUtils.remove(dato, "[/.|/,]");
    }

    /**
     * Formato fecha bd string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoFechaBd(String dato) {
        return StringUtils.right(CEROS6.concat(StringUtils.replace(dato, "/", StringUtils.EMPTY)), 6);
    }

    /**
     * Formato documento string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoDocumento(String dato) {
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(dato));
    }

    /**
     * Formato tarjeta string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoTarjeta(String dato) {
        return String.format(FORMATO16CEROSIZQ, Long.parseLong(dato));

    }

    /**
     * Formato pago string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formato17Ceros(String dato) {
        dato = formatoValor(dato);
        return  String.format(FORMATO17CEROSIZQ, Long.parseLong(dato));

    }

    /**
     * Formato pago USD string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formato15Ceros(String dato) {
        dato = formatoValor(dato);
        return String.format(FORMATO15CEROSIZQ, Long.parseLong(dato));
    }

    /**
     * Formato fondo string.
     *
     * @param dato the dato
     * @return the string
     */
    public static String formatoFondo(String dato) {
        return String.format(FORMATO13CEROSIZQ, Long.parseLong(dato));

    }

    /**
     * Reemplazar modelo datos string.
     *
     * @param datosCampos the datos campos
     * @return the string
     */
    public static String reemplazarModeloDatos(String datosCampos) {
        return StringUtils.remove(datosCampos, "(co.com.bancolombia.backend.modelo.)|<|>|productos.|transversal.|@\\w+").replaceAll(",", "\n").replaceAll("\\[", "[\n").replaceAll("\\]", "\n]");
    }

    /**
     * Obtiene el nombre del archivo iseries que se valida en el back
     * @param fileName nombre completo dado en el feature
     * @return nombre del archivo iseries
     */
    public static String getFileName(String fileName) {

        int longitud = fileName.length();
        int intIndex = fileName.indexOf(AdministradorConstante.GUION);
        return fileName.substring(intIndex+1,longitud);
    }
}

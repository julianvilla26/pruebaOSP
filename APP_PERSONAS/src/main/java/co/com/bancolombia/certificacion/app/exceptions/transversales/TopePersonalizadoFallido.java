package co.com.bancolombia.certificacion.app.exceptions.transversales;

public class TopePersonalizadoFallido extends AssertionError {

    public static final String TOPES_PERSONALIZADOS_FALLIDOS = "Los topes personalizados no pueden ser verificados";

    public TopePersonalizadoFallido(String mensaje) {
        super(mensaje);
    }

    public TopePersonalizadoFallido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

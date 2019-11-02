package co.com.bancolombia.certificacion.app.exceptions.comunes;

public class LogCanalFallido extends AssertionError {

    public static final String LOG_CANAL_FALLIDO = "Los valores obtenidos en el log del canal no son iguales a los valores esperados";

    public LogCanalFallido(String mensaje) {
        super(mensaje);
    }

    public LogCanalFallido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

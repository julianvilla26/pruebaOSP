package co.com.bancolombia.certificacion.app.exceptions.transversales;

public class LogTefFallido extends AssertionError {

    public static final String LOG_TEF_FALLIDO = "Los valores obtenidos en el Log Tef no son iguales a los valores esperados";

    public LogTefFallido(String mensaje) {
        super(mensaje);
    }

    public LogTefFallido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

package co.com.bancolombia.certificacion.app.exceptions.pagos;

public class MensajeNoPresentadoException extends AssertionError {
    public static final String MENSAJE_NO_PRESENTADO = "No se presenta el mensaje de pago supera el total de la deuda";

    public MensajeNoPresentadoException(String message, Throwable cause) {
        super(message, cause);
    }
}

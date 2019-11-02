package co.com.bancolombia.certificacion.app.exceptions.pagos;

public class PagoNoRealizadoException extends AssertionError  {
    public static final String PAGO_NO_REALIZADO= "No se presenta la información en la pantalla de confirmación";

    public PagoNoRealizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}

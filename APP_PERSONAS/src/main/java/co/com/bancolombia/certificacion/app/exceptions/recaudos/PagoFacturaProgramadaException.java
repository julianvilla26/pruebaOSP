package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class PagoFacturaProgramadaException extends AssertionError {
    public static final String NO_SE_PAGO_FACTURA_PROGRAMADA = "No se realizó el pago correcto de la factura programada";

    public PagoFacturaProgramadaException(String message, Throwable cause) {
        super(message, cause);
    }
}
package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class PagoFacturaRedebanException extends AssertionError {
    public static final String NO_SE_PAGO_FACTURA_REDEBAN = "No se realizó el pago correcto de la factura redeban";

    public PagoFacturaRedebanException(String message, Throwable cause) {
        super(message, cause);
    }
}
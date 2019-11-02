package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class PagoFacturaInscritaException extends AssertionError {
    public static final String NO_SE_PAGO_FACTURA_INSCRITA = "No se realizó el pago correcto de la factura inscrita";

    public PagoFacturaInscritaException(String message, Throwable cause) {
        super(message, cause);
    }
}
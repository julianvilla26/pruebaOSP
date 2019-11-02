package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class NoConsultaDetalleFacturaException extends AssertionError {
    public static final String NO_CONSULTA_DETALLE_FACTURAS = "No consulta el detalle de la factura seleccionada";

    public NoConsultaDetalleFacturaException(String message, Throwable cause) {
        super(message, cause);
    }
}
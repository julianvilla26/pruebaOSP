package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class ProgramacionFacturaException extends AssertionError {
    public static final String FACTURAS_SIN_PROGRAMACION_EXCEPTION = "No se realizó la programación de la factura";

    public ProgramacionFacturaException(String message, Throwable cause) {
        super(message, cause);
    }
}
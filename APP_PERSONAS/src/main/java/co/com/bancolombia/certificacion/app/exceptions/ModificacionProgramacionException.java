package co.com.bancolombia.certificacion.app.exceptions;

public class ModificacionProgramacionException extends AssertionError {
    public static final String MENSAJE_MODIFICACION= "La programación de la factura no se modificó";

    public ModificacionProgramacionException(String message, Throwable cause) {
        super(message, cause);
    }
}
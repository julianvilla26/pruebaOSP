package co.com.bancolombia.certificacion.app.exceptions;

public class EliminacionFacturasException extends AssertionError {
    public static final String MENSAJE_ELIMINACION= "La factura seleccionada no se eliminó";

    public EliminacionFacturasException(String message, Throwable cause) {
        super(message, cause);
    }
}
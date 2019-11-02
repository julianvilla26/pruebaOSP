package co.com.bancolombia.certificacion.app.exceptions.inscripcion;

public class ProductoPenditeteActivacionException extends AssertionError {
    public static final String NO_RECONOCE_PRODUCTO_PENDIENTE_ACTIVACION= "No reconoce producto pendiente de activacion";

    public ProductoPenditeteActivacionException(String message, Throwable cause) {
        super(message, cause);
    }
}
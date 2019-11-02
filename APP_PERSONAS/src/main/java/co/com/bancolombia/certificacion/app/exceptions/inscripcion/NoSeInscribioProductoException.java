package co.com.bancolombia.certificacion.app.exceptions.inscripcion;

public class NoSeInscribioProductoException extends AssertionError {
    public static final String PRODUCTO_NO_INSCRITO= "No se inscribió el producto con los datos correctos";

    public NoSeInscribioProductoException(String message, Throwable cause) {
        super(message, cause);
    }
}
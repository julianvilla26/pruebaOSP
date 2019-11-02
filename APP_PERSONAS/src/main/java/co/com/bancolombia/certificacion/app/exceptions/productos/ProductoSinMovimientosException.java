package co.com.bancolombia.certificacion.app.exceptions.productos;

public class ProductoSinMovimientosException extends AssertionError {
    public static final String SIN_MOVIMIENTOS= "La cuenta no tiene movimientos";

    public ProductoSinMovimientosException(String message, Throwable cause) {
        super(message, cause);
    }
}
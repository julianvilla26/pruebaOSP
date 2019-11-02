package co.com.bancolombia.certificacion.app.exceptions.productos;

public class ProductoFallido extends AssertionError {

    public static final String PRODUCTO_NO_EXISTE = "El productos no existe";

    public ProductoFallido(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoFallido(String detailMessage) {
        super(detailMessage);
    }


}

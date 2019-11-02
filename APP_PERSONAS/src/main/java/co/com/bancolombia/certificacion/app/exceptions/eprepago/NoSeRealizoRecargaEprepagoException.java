package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoSeRealizoRecargaEprepagoException extends AssertionError {
    public static final String MENSAJE_RECARGA_EPREPAGO_NO_REALIZADA = "No se pudo realizar la recarga de la tarjeta virtual ePrepago";

    public NoSeRealizoRecargaEprepagoException(String mensaje, Throwable causa){super(mensaje, causa);}
}
package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoSeRealizoLaDescargaExitosaException extends AssertionError{
    public static final String MENSAJE_DESCARGA_EPREPAGO_NO_EXITOSA = "No se realizó la descarga de la tarjeta virtual e-Prepago de forma exitosa";

    public NoSeRealizoLaDescargaExitosaException(String mensaje, Throwable causa){super(mensaje, causa);}
}
package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoRealizoActivacionEprepagoException extends AssertionError{
    public static final String NO_SE_REALIZO_ACTIVACION_EPREPAGO = "No fue realizada correctamente la activación de e-prepago";

    public NoRealizoActivacionEprepagoException(String mensaje, Throwable causa){super(mensaje, causa);}
}
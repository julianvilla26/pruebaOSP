package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoPresentaMensajeNumeroMaximoInactivacionesException extends AssertionError{
    public static final String NO_PRESENTA_MENSAJE_NUMERO_MAXIMO_INACTIVACIONES  = "La aplicación no presenta el mensaje de número máximo de inactivaciones";

    public NoPresentaMensajeNumeroMaximoInactivacionesException(String mensaje, Throwable causa){super(mensaje, causa);}
}
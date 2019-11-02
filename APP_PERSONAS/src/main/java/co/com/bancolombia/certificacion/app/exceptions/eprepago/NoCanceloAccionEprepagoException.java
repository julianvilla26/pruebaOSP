package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoCanceloAccionEprepagoException extends AssertionError{
    public static final String NO_CANCELO_ACCION_EPREPAGO = "La acción no fue cancelada";

    public NoCanceloAccionEprepagoException(String mensaje, Throwable causa){super(mensaje, causa);}
}
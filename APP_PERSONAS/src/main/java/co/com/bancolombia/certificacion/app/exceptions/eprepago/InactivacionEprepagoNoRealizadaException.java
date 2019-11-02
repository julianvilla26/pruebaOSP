package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class InactivacionEprepagoNoRealizadaException extends AssertionError{
    public static final String NO_SE_REALIZO_INACTIVACION = "La inactivación no fue realizada correctamente";

    public InactivacionEprepagoNoRealizadaException(String mensaje, Throwable causa){super(mensaje, causa);}
}
package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoSeRealizoLaConsultaException extends AssertionError {
    public static final String MENSAJE_CONSULTA_NO_REALIZADA = "No se realizo la consulta de forma exitosa de eprepago";

    public NoSeRealizoLaConsultaException(String mensaje, Throwable causa){super(mensaje, causa);}
}
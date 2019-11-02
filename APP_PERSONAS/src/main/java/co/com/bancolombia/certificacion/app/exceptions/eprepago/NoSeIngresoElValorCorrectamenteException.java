package co.com.bancolombia.certificacion.app.exceptions.eprepago;

public class NoSeIngresoElValorCorrectamenteException extends AssertionError{
    public static final String MENSAJE_VALOR_DE_RECARGA_NO_INGRESADO = "El valor de la recarga no fue ingresado de manera correcta";

    public NoSeIngresoElValorCorrectamenteException(String mensaje, Throwable causa){super(mensaje, causa);}
}
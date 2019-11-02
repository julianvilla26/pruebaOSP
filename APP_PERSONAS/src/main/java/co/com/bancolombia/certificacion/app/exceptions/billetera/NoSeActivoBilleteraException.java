package co.com.bancolombia.certificacion.app.exceptions.billetera;

public class NoSeActivoBilleteraException extends AssertionError {
    public static final String MENSAJE_BILLETERA_NO_ACTIVADA = "No se ha realizado la activacion exitosa de Billetera";

    public NoSeActivoBilleteraException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
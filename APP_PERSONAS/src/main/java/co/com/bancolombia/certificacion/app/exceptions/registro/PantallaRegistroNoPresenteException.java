package co.com.bancolombia.certificacion.app.exceptions.registro;

public class PantallaRegistroNoPresenteException extends AssertionError {
    public static final String MENSAJE_PANTALLA_REGISTRO_NO_VISIBLE = "Pantalla de registro no esta visible";

    public PantallaRegistroNoPresenteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

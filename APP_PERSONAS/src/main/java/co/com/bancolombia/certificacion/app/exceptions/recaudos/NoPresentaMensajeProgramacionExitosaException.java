package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class NoPresentaMensajeProgramacionExitosaException extends AssertionError  {
    public static final String NO_PRESENTA_MENSAJE_PROGRAMACION_EXITOSA = "No se presenta el mensaje de validación exitosa en la pantalla de confirmación";

    public NoPresentaMensajeProgramacionExitosaException(String message, Throwable cause) {
        super(message, cause);
    }
}

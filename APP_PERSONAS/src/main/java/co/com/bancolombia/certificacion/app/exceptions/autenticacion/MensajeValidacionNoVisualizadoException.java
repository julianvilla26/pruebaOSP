package co.com.bancolombia.certificacion.app.exceptions.autenticacion;

public class MensajeValidacionNoVisualizadoException extends AssertionError{
    public static final String MENSAJE_VALIDACION_NO_ENCONTRADO = "Mensaje de validacion no visualizado";

    public MensajeValidacionNoVisualizadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

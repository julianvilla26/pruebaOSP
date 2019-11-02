package co.com.bancolombia.certificacion.app.exceptions.codigoqr;

public class MensajeVerificacionNoPresentadoException extends AssertionError {
    public static final String NO_PRESENTA_MENSAJE_CONFIRMACION = "El mensaje de verificación no fue presentado";

    public MensajeVerificacionNoPresentadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

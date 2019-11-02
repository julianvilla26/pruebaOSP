package co.com.bancolombia.certificacion.app.exceptions.autenticacion;

public class MensajeClaveBloqueadaNoVisualizadoException extends AssertionError {
    public static final String MENSAJE_CLAVE_BLOQUEADA_NO_ENCONTRADO = "Mensaje de clave bloqueada no visualizado";

    public MensajeClaveBloqueadaNoVisualizadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

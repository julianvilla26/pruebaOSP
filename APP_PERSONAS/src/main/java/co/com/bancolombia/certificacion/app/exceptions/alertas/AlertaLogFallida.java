package co.com.bancolombia.certificacion.app.exceptions.alertas;

public class AlertaLogFallida extends AssertionError {

    public static final String ALERTA_LOG_FALLIDA = "La alerta del log no puede ser verificada";

    public AlertaLogFallida(String mensaje) {
        super(mensaje);
    }

    public AlertaLogFallida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

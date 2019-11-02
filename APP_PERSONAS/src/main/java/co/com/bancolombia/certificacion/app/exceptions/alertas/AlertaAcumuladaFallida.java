package co.com.bancolombia.certificacion.app.exceptions.alertas;

public class AlertaAcumuladaFallida extends AssertionError {

    public static final String ALERTA_ACUMULADA_FALLIDA = "La alerta acumulada no puede ser verificada";

    public AlertaAcumuladaFallida(String mensaje) {
        super(mensaje);
    }

    public AlertaAcumuladaFallida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

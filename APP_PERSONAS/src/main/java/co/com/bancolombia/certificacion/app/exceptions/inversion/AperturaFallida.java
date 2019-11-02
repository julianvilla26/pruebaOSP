package co.com.bancolombia.certificacion.app.exceptions.inversion;

public class AperturaFallida extends AssertionError {

    public static final String MENSAJE_APERTURA_INVERSION_VIRTUAL_FALLIDA = "La apertura de inversion virtual ha fallado";

    public AperturaFallida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
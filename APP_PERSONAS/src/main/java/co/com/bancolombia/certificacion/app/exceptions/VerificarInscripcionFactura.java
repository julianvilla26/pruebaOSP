package co.com.bancolombia.certificacion.app.exceptions;

public class VerificarInscripcionFactura extends AssertionError  {
    public static final String INSCRIPCION_FALLIDA = "No se encontraron los datos de la inscripción o esta fue fallida";

    public VerificarInscripcionFactura(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

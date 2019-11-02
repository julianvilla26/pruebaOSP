package co.com.bancolombia.certificacion.app.exceptions.crediagil;

public class DesembolsoCrediagilFueraRangoException extends AssertionError {
    public static final String PERMITE_AVANZAR_DESEMBOLSO = "No se presentó el mensaje de valor fuera de rango o se habilitaron los botonos de siguiente";

    public DesembolsoCrediagilFueraRangoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

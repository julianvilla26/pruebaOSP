package co.com.bancolombia.certificacion.app.exceptions.crediagil;

public class DesembolsoNoRealizadoException extends AssertionError {
    public static final String DESEMBOLSO_NO_REALIZADO = "El desembolso del crediágil no fue realizado correctamente";

    public DesembolsoNoRealizadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

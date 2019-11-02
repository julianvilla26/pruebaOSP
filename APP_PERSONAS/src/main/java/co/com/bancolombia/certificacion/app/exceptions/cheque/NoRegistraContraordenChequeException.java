package co.com.bancolombia.certificacion.app.exceptions.cheque;

public class NoRegistraContraordenChequeException extends AssertionError {
    public static final String NO_INSCRIBE_CONTRAORDEN = "La contraorden no se realizó exitosamente";

    public NoRegistraContraordenChequeException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
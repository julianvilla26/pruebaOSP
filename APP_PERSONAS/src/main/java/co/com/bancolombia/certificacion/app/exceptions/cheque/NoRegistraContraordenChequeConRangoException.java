package co.com.bancolombia.certificacion.app.exceptions.cheque;

public class NoRegistraContraordenChequeConRangoException extends AssertionError{
    public static final String NO_INSCRIBE_CONTRAORDEN_CON_RANGO = "La contraorden de cheque con rango no se realizó exitosamente";

    public NoRegistraContraordenChequeConRangoException(String mensaje, Throwable causa){super(mensaje, causa);}
}
package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class PagoRedebanNoRealizadoException extends AssertionError  {
    public static final String PAGO_REDEBAN_NO_REALIZADO = "El pago redeban no fue realizado correctamente";

    public PagoRedebanNoRealizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}


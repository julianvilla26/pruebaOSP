package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class HistoricoPagoException extends AssertionError {
    public static final String NO_TIENE_HISTORICO_DE_PAGOS = "El usuario no tiene historico de pago ";

    public HistoricoPagoException(String message, Throwable cause) {
        super(message, cause);
    }
}
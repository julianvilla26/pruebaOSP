package co.com.bancolombia.certificacion.app.exceptions.recaudos;

public class NoConsultaFacturaException extends AssertionError {
    public static final String NO_CONSULTA_FACTURAS = "No se realiza la consulta de facturas";

    public NoConsultaFacturaException(String message, Throwable cause) {
        super(message, cause);
    }
}
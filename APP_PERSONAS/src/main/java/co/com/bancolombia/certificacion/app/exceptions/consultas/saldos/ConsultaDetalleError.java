package co.com.bancolombia.certificacion.app.exceptions.consultas.saldos;

public class ConsultaDetalleError extends AssertionError {

    public static final String MENSAJE_CONSULTA_DETALLE_CUENTA_DEPOSITO_FALLIDO = "El detalle de productos de la cuenta deposito ha sido fallida";

    public static final String MENSAJE_CONSULTA_DETALLE_INVERSION_VIRTUAL_FALLIDO = "La Consulta del detalle de productos de inversion virtual ha sido fallida";

    public ConsultaDetalleError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
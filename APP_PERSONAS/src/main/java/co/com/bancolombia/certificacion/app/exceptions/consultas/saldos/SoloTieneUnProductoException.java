package co.com.bancolombia.certificacion.app.exceptions.consultas.saldos;

public class SoloTieneUnProductoException extends AssertionError{
    public static final String MENSAJE_SOLO_TIENE_UN_PRODUCTO = "El cliente solo posee un producto y no varios como se espera";

    public SoloTieneUnProductoException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}

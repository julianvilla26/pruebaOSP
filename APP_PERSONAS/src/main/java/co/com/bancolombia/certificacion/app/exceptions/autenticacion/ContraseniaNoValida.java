package co.com.bancolombia.certificacion.app.exceptions.autenticacion;


public class ContraseniaNoValida extends AssertionError {

    public static final String MENSAJE_LONGITUD_NO_VALIDA = "La longitud de la clave no es valida";

    public ContraseniaNoValida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

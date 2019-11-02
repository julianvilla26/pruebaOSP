package co.com.bancolombia.certificacion.app.exceptions.datosseguridad;

public class NoSeActualizaronDatosException extends AssertionError{
    public static final String ACTUALIZACION_FALLODA = "La actualización de datos no se pudo realizar";

    public NoSeActualizaronDatosException(String mensaje, Throwable causa) {super(mensaje, causa);
    }
}

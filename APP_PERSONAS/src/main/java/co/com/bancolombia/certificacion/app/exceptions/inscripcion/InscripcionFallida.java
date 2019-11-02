package co.com.bancolombia.certificacion.app.exceptions.inscripcion;

public class InscripcionFallida extends AssertionError{

    public static final String INSCRIPCION_FALLIDA = "La inscripcion no se pudo realizar";
    public static final String CASO_ALTERNO_FALLIDO = "El caso alterno no pudo ser verificado para la inscripción";

    public InscripcionFallida(String mensaje) { super(mensaje);
    }

    public InscripcionFallida(String mensaje, Throwable causa) {super(mensaje, causa);
    }
}

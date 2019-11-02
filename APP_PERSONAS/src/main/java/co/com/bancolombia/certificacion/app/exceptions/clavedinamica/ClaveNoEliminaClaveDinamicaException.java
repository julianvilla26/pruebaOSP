package co.com.bancolombia.certificacion.app.exceptions.clavedinamica;

public class ClaveNoEliminaClaveDinamicaException extends AssertionError {
    public static final String NO_ELIMINA_CLAVE_DINAMICA = "No se realizó la eliminación, verifique";

    public ClaveNoEliminaClaveDinamicaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
package co.com.bancolombia.certificacion.app.exceptions.clavedinamica;

public class UsuarioNoSeEncuentraInscritoParaClaveDinamicaException extends AssertionError {
    public static final String USUARIO_NO_INSCRITO = "El usuario no se encuentra inscrito a clave dinamica en el dispositivo";

    public UsuarioNoSeEncuentraInscritoParaClaveDinamicaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

package co.com.bancolombia.certificacion.app.exceptions.transversales;

public class ArchivosIseriesFallido extends AssertionError {

    public static final String ARCHIVOS_ISERIES_FALLIDO = "Las verificaciones de los archivos en iseries no se realizaron correctamente.";

    public ArchivosIseriesFallido(String message) {
        super(message);
    }

    public ArchivosIseriesFallido(String message, Throwable cause) {
        super(message, cause);
    }

}

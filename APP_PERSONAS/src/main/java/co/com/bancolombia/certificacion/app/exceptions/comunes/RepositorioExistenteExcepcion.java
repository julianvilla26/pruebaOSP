package co.com.bancolombia.certificacion.app.exceptions.comunes;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class RepositorioExistenteExcepcion extends SerenityManagedException {

    private static final String MENSAJE_CON_FORMATO = "El repositorio llamado %s ya existe";

    public RepositorioExistenteExcepcion(String nombreRepositorio, Throwable excepcion) {
        super(String.format(MENSAJE_CON_FORMATO, nombreRepositorio), excepcion);
    }

}

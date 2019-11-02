package co.com.bancolombia.certificacion.app.utilidades.enumeradores;

import co.com.bancolombia.certificacion.app.exceptions.AfirmacionDelProducto;
import co.com.bancolombia.certificacion.app.questions.fabrica.FabricaLogCanal;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public enum ArchivosLogCanalIseries {

    COMFFLGWWW0369 (FabricaLogCanal.elLogCanal0369(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0322 (FabricaLogCanal.elLogCanal0322(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0325 (FabricaLogCanal.elLogCanal0325(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0326 (FabricaLogCanal.elLogCanal0326(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0533 (FabricaLogCanal.elLogCanal0533(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA);


    private static final Logger LOGGER = LogManager.getLogger();

    Question<Boolean> question;
    Class clase;
    String mensaje;
    ArchivosLogCanalIseries(Question<Boolean> question, Class clase, String mensaje) {
        this.question = question;
        this.clase = clase;
        this.mensaje = mensaje;
    }

    public Question<Boolean> delArchivo() {
        return question;
    }
    public Class<AssertionError> getException() {
        return clase;
    }
    public String getMessage() {
        return mensaje;
    }

    public static ArchivosLogCanalIseries getSearchFile(String nombre) {

        ArchivosLogCanalIseries[] lista = ArchivosLogCanalIseries.values();
        boolean existe = Arrays.stream(lista).anyMatch(x -> x.name().equalsIgnoreCase(nombre));
        if (!existe) {
            LOGGER.error(new RuntimeException("".concat(nombre) + "'s question not exits"));
        }
        return ArchivosLogCanalIseries.valueOf(nombre);
    }
}

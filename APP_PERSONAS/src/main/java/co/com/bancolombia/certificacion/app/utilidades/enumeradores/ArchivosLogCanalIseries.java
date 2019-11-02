package co.com.bancolombia.certificacion.app.utilidades.enumeradores;

import co.com.bancolombia.certificacion.app.exceptions.productos.AfirmacionDelProducto;
import co.com.bancolombia.certificacion.app.questions.fabrica.logcanal.FabricaLogCanal;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public enum ArchivosLogCanalIseries {

    COMFFLGWWW0369(FabricaLogCanal.elLogCanal0369(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0360(FabricaLogCanal.elLogCanal0360(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0345(FabricaLogCanal.elLogCanal0345(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW1756(FabricaLogCanal.elLogCanal1756(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0260(FabricaLogCanal.elLogCanal0260(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW0410(FabricaLogCanal.elLogCanal0410(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWWW1228(FabricaLogCanal.elLogCanal1228(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    COMFFLGWW00228(FabricaLogCanal.elLogCanal0228(), AfirmacionDelProducto.class,AfirmacionDelProducto.NO_FUNCIONA),
    ;

    private static final Logger LOGGER = LogManager.getLogger();

    Question<Boolean> question;
    Class clase;
    String mensaje;

    ArchivosLogCanalIseries(Question<Boolean> question, Class clase, String mensaje) {
        this.question = question;
        this.clase = clase;
        this.mensaje = mensaje;
    }

    public static ArchivosLogCanalIseries getSearchFile(String nombre) {

        ArchivosLogCanalIseries[] lista = ArchivosLogCanalIseries.values();
        boolean existe = Arrays.stream(lista).anyMatch(x -> x.name().equalsIgnoreCase(nombre));
        if (!existe) {
            LOGGER.error(new RuntimeException("".concat(nombre) + "'s question not exits"));
        }
        return ArchivosLogCanalIseries.valueOf(nombre);
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
}

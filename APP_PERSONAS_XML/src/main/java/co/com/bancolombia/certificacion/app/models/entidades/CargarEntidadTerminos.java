package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.transaccion.TerminosCondiciones;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Current usuario entity.
 */
public class CargarEntidadTerminos {

    private static TerminosCondiciones terminosCondiciones = new TerminosCondiciones();

    private CargarEntidadTerminos() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets usuario.
     *
     * @return the usuario
     */
    public static TerminosCondiciones getTermsAndConditions() {
        return terminosCondiciones;
    }

    /**
     * Sets usuario.
     *
     * @param data the data
     */
    public static void conEstos(List<String> data) {
        terminosCondiciones.setVersionTermCond(data.get(0));
    }
}
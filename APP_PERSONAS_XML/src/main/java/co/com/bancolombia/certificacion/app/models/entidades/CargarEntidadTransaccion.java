package co.com.bancolombia.certificacion.app.models.entidades;

import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.backend.utilidades.managers.DateManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante.HOUR_FORMAT;

/**
 * The type Current trasaction config entity.
 */
public class CargarEntidadTransaccion {

    private static ConfiguracionTransaccion configuracionTransaccion = new ConfiguracionTransaccion();

    private CargarEntidadTransaccion() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets transaccion.
     *
     * @return the transaccion
     */
    public static ConfiguracionTransaccion getConfiguracionTransaccion() {
        return configuracionTransaccion;
    }

    /**
     * Sets transaccion.
     *
     * @param datos the data transaccion
     */
    public static void conEstos(List<String> datos) {
        String transaccionHour = DateManager.obtenerFechaSistema(HOUR_FORMAT);
        configuracionTransaccion.setIdentificadorCaso(datos.get(0));
        configuracionTransaccion.setOrientacionCaso(datos.get(1));
        configuracionTransaccion.setCodigoError(datos.get(2));
        configuracionTransaccion.setCodigoTransaccion(datos.get(3));
        configuracionTransaccion.setResultadoEsperado(datos.get(4));
        configuracionTransaccion.setTipoLogCanal("WWW");
        configuracionTransaccion.setHoraTransaccion(transaccionHour);
    }
}

package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.fondosdeinversion;

import co.com.bancolombia.backend.iseries.consultas.Consulta;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.FondoLibrerias;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class FondosInversion {

    private static final Logger LOGGER = LogManager.getLogger("CONSULTA FONDOS ENCARC");

    private FondosInversion() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

    public static List<Map<String, Object>> consultarExistenciaFondosEncarc(Actor actor) {
        Map<String, Object> dataForQuery = new HashMap<>();
        List<Map<String, Object>> listaFondosIversion = new ArrayList<>();
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        dataForQuery.put("DOCUMENTO", datosPrincipales.getUsuario().getNumeroDocumento());
        List<String> librerias = new ArrayList<>();

        FondoLibrerias.BIBLIOTECA_POR_CODIGO.forEach((clave, valor) -> {
            if (!librerias.contains(valor)) {
                librerias.add(valor);
            }
        });

        for (String libreria : librerias) {
            String query = QueryManager.CONSULTAS.getString("SQL.ENCARC.consultaFondosInversion");
            query = query.replace("libreria", libreria);
            listaFondosIversion.addAll(Consulta.ejecutar(query, dataForQuery));

        }

        if (listaFondosIversion.isEmpty()) {
            LOGGER.error("Error al ejecutar la consulta.");
        }
        return listaFondosIversion;
    }

}

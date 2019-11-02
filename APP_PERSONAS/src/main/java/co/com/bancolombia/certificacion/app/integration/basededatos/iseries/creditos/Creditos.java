package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.creditos;

import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class Creditos {

    private Creditos() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }


    public static List<Map<String, Object>> saldoCreditosConsolidado(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DOCUMENTO", StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()));
        String sql = QueryManager.CONSULTAS.getString("SQL.CXREF.consultarListaCreditos");
        return Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
    }
}

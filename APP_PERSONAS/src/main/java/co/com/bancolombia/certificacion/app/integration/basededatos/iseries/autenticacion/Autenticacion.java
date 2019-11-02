package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.autenticacion;

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

public class Autenticacion {

    private Autenticacion() { throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD); }

    public static final String DOCUMENTO = "DOCUMENTO";

    public static List<Map<String, Object>> consultaDeExistenciaDelCliente(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()));
        String sql = QueryManager.CONSULTAS.getString("SQL.CNAME_WWWFFUSRSV.consultaCliente");
        return Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
    }
}

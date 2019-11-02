package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorFechas;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.CanalesSistemas;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class Tarjetas {

    private Tarjetas() {throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD); }

    public static List<Map<String, Object>> saldoConsolidadoTarjetas(Actor actor){
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        List<Producto> producto = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        Map<String, Object> dataForQuery = new HashMap<>();

        String documentoFormateado = String.format("%s%s%s", "%", datosPrincipales.getUsuario().getNumeroDocumento(), "%");

        dataForQuery.put("ANIO", AdministradorFechas.obtenerFechaSistema("yy"));
        dataForQuery.put("MES", AdministradorFechas.obtenerFechaSistema("MM"));
        dataForQuery.put("DIA", AdministradorFechas.obtenerFechaSistema("dd"));
        dataForQuery.put("SISTEMA", CanalesSistemas.APP);
        dataForQuery.put("DOCUMENTO", documentoFormateado);
        dataForQuery.put("SIZE" , producto.size());

        String sql = QueryManager.CONSULTAS.getString("SQL.PCCLIBRAMD.consultarLogTFSaldosTDC");
        return Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
    }

    public static List<Map<String, Object>> pertenenciaTarjetas(Actor actor){
        ConfiguracionTransaccion datosPrincipales =  actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();

        dataForQuery.put("NUMERO_DOCUMENTO_CLIENTE", StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()));

        String sql = QueryManager.CONSULTAS.getString("SQL.CXREF.saldosPertenenciaTDC");
        return Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());

    }


}




package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.transversal;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorFechas;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.CanalesSistemas;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.formatoTipoCuentaNumero;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.TIENE_PRODUCTOS;

public class Transversales {

    public Transversales() { throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD); }

    public static final String FECHA = "FECHA";
    public static final String FECHASISTEMA = "yyyyMMdd";
    public static final String DOCUMENTO = "DOCUMENTO";

    public static String verificarElDebitoEnMOVTFLOGTF(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DIA", AdministradorFechas.obtenerFechaSistema("dd"));
        dataForQuery.put("CUENTADEBITO", depositos.getNumero().substring(3,11));
        dataForQuery.put("TIPOCUENTADEBITO", formatoTipoCuentaNumero(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS.getString("SQL.PCCFFMOVTFLOGTF.consultarRegistroDeb");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    public static String verificarElCreditoEnMOVTFLOGTF(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        Map<String, Object> dataForQuery = new HashMap<>();

        dataForQuery.put("DIA", AdministradorFechas.obtenerFechaSistema("dd"));
        dataForQuery.put("CUENTACREDITO", depositos.getNumero().substring(3,11));
        dataForQuery.put("TIPOCUENTACREDITO", formatoTipoCuentaNumero(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS.getString("SQL.PCCFFMOVTFLOGTF.consultarRegistroCre");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    public String consultarClaveDinamica(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        String claveDinamica = "";

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, datosPrincipales.getUsuario().getNumeroDocumento());
        dataForQuery.put(FECHA, AdministradorFechas.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("CANAL", CanalesSistemas.BLP);
        dataForQuery.put("HORA", AdministradorFechas.obtenerFechaSistema("hhmmss"));
        String sql = QueryManager.CONSULTAS.getString("SQL.PCCFFLGAEN.consultaClaveDinamica");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        claveDinamica =  resultadoConsulta.get(0).get("aenmsgenv").toString();
        return claveDinamica;
    }

    public boolean verifyTopesPersonalizadosPCCFFPPCLI(Actor actor) {
        boolean result = false;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, datosPrincipales.getUsuario().getNumeroDocumento());
        String sql = QueryManager.CONSULTAS.getString("SQL.CABFFTARJ.validarRegistroEprepago");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());

        if (resultadoConsulta != null) {
            result = true;
        }
        return result;
    }

}

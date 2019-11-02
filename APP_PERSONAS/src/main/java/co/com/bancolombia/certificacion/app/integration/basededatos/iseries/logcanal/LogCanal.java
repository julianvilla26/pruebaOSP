package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.logcanal;

import co.com.bancolombia.backend.iseries.transversal.log.trace.BackTrace;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorFechas;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.backend.utilidades.enums.CanalesSistemas.WWW;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class LogCanal {

    public static final Logger LOGGER = LogManager.getLogger(LogCanal.class.getName());

    private LogCanal() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

    public static List<Map<String, Object>> consultaLogCanalTrama220230(Actor actor) {
        Map<String, Object> dataForQuery = new HashMap<>();
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        BackTrace backTrace = new BackTrace();
        String trace = "";
        String horaConsulta = "";
        List<Map<String, Object>> listOfFounded = null;
        try {
            horaConsulta = AdministradorFechas.obtenerFechaSistema("hhmmss");
            co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
            usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
            co.com.bancolombia.backend.modelo.transversal.Transaccion transaccion = new co.com.bancolombia.backend.modelo.transversal.Transaccion();
            transaccion.setCodigoTransaccion(datosPrincipales.getCodigoTransaccion());
            transaccion.setHoraTransaccion(horaConsulta);
            trace = backTrace.consultarTrace(usuario, transaccion, WWW);
            datosPrincipales.setTrace(trace);

            dataForQuery.put("TRACE", trace);
            String sql = QueryManager.CONSULTAS.getString("SQL.COMFFLGWWW.tramaDatos_0220_0230");
            listOfFounded = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return listOfFounded;
    }
}

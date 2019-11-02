package co.com.bancolombia.certificacion.app.integration.basededatos.finacle;

import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finacle {

    public Finacle() { throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD); }

    public static final Logger LOGGER = LogManager.getLogger(Finacle.class.getName());

    public static List<Map<String, Object>> consultTitleClientFinacle() {
        Map<String, Object> dataForQuery = new HashMap<>();
        List<Map<String, Object>> listOfFounded = null;
        try {
            dataForQuery.put("NUMEROINVERSION", Serenity.sessionVariableCalled("NumeroInversion"));
            String sql = QueryManager.ORACLE_BATCH.getString("SQL.TITULO_CLIENTE");
            listOfFounded = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getOracleConnection());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return listOfFounded;
    }


}

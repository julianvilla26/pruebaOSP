package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.tarjetas;

import co.com.bancolombia.backend.iseries.transversal.productos.eprepago.BackTarjetaEPrepago;
import co.com.bancolombia.backend.modelo.productos.TarjetaEPrepago;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class Eprepago {

    private Eprepago() { throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD); }

    public static final Logger LOGGER = LogManager.getLogger(Eprepago.class.getName());


    public static List<Map<String, Object>> verificoExistenciaDeLaEprepago(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DOCUMENTO", datosPrincipales.getUsuario().getNumeroDocumento());
        dataForQuery.put("TIPODOCUMENTO", datosPrincipales.getUsuario().getTipoDocumento());
        String sql = QueryManager.CONSULTAS.getString("SQL.CABFFTARJ.consultaTarjetaEprepago");
        return Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
    }

    public static List<Map<String,Object>>verificoElDetalleDeLaEprepago(Actor actor){
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DOCUMENTO", datosPrincipales.getUsuario().getNumeroDocumento());
        dataForQuery.put("TIPODOCUMENTO", datosPrincipales.getUsuario().getTipoDocumento());
        String sql = QueryManager.CONSULTAS.getString("SQL.CABFFTARJ.consultarDetalleTarjetaEprepago");
        return Consulta.ejecutar(sql,dataForQuery,ConnectionManager.getIseriesConnection());

    }


    public static boolean verificoEstadoDeLaActivacionDeLaEprepago(Actor actor) {
        boolean resultadoActivacion = false;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
        usuario.setTipoDocumento(datosPrincipales.getUsuario().getTipoDocumento());
        usuario.setUsername(datosPrincipales.getUsuario().getNombreUsuario());
        usuario.setPassword(datosPrincipales.getUsuario().getClave());
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago stateEprepago = null;
        try {
            stateEprepago = ePrepago.consultarDetalleEprepago(usuario, AdministradorConstante.CODIGO_BANCO_EPREPAGO);
            if (stateEprepago != null && AdministradorConstante.ESTADO_TARJETA_ACTIVA.equals(stateEprepago.getEstado())){
                resultadoActivacion = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return resultadoActivacion;
    }

    public static boolean verificoEstadoDeLaInactivacionDeLaEprepago(Actor actor) {
        boolean resultadoInactivacion = false;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
        usuario.setTipoDocumento(datosPrincipales.getUsuario().getTipoDocumento());
        usuario.setUsername(datosPrincipales.getUsuario().getNombreUsuario());
        usuario.setPassword(datosPrincipales.getUsuario().getClave());
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago stateEprepago = null;
        try {
            stateEprepago = ePrepago.consultarDetalleEprepago(usuario, AdministradorConstante.CODIGO_BANCO_EPREPAGO);
            if (stateEprepago != null && AdministradorConstante.ESTADO_TARJETA_INACTIVA.equals(stateEprepago.getEstado())){
                resultadoInactivacion = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return resultadoInactivacion;
    }

    public static TarjetaEPrepago verificoElRegistroDeLaEprepago(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago validarRegistroEprepago = null;
        try {
            validarRegistroEprepago = ePrepago.verifcarRegistroEprepago(datosPrincipales.getUsuario().getNumeroDocumento());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return validarRegistroEprepago;
    }

    public static boolean verificoRegistroDeLaEprepago(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        boolean validarRegistroEprepago = false;
        try {
            validarRegistroEprepago = ePrepago.verificarRegistroEprepagoTarj(datosPrincipales.getUsuario().getNumeroDocumento());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return validarRegistroEprepago;
    }

    public static boolean validarCreditoEprepago(String saldoAntes, String saldoDespues, String monto, String orientacion) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(monto);
        return AdministradorConstante.ACIERTO.equalsIgnoreCase(orientacion) ? saldoAnterior.add(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }

    public static boolean validarDebitoEprepago(String saldoAntes, String saldoDespues, String monto, String orientacion) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(monto);
        return AdministradorConstante.ACIERTO.equalsIgnoreCase(orientacion) ? saldoAnterior.subtract(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }
}

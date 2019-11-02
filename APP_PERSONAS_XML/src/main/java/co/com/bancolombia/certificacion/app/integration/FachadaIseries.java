package co.com.bancolombia.certificacion.app.integration;

import co.com.bancolombia.backend.iseries.transversal.log.trace.BackTrace;
import co.com.bancolombia.certificacion.app.models.entidades.*;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.transaccion.TerminosCondiciones;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.administradores.DateManager;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.CanalesSistemas;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.backend.utilidades.enums.CanalesSistemas.WWW;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.formatoTipoCuentaNumero;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoCuentaLetra;

/**
 * The type Backend integration.
 */
public class FachadaIseries {
    /**
     * The constantes deposit.
     */
    private static final Logger LOGGER = LogManager.getLogger(FachadaIseries.class.getName());
    private static final String CUENTA = "CUENTA";
    private static final String TIPOCUENTA = "TIPOCUENTA";
    private static final String SALDOANTES = "saldoDepositoAntes";
    private static final String SALDODESPUES = "saldoDepositoDespues";
    private static final String FECHA = "FECHA";
    private static final String FECHASISTEMA = "yyyyMMdd";
    private static final String DOCUMENTO = "DOCUMENTO";


    /**
     * Verify credi agil detail credi agil.
     *
     * @return the credi agil
     */
    public static List<Map<String, Object>> verifyCrediAgilDetail() {
        Map<String, Object> dataForQuery = new HashMap<>();
        Usuario usuario = CargarEntidadUsuario.getUsuario();
        String nit = String.format("%s%s%s", "%",usuario.getNumeroDocumento(),"%");
        dataForQuery.put("NIT", nit);
        String sql = QueryManager.CONSULTAS_APP.getString("SQL.CPSFFMAECP.consultarDetalleCrediAgil");
        return Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
    }

    /**
     * Balance deposit before.
     *
     */
    public static void balanceDepositBefore(){
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
        String saldoDisponible ="";
        String saldoCanje ="";
        String saldoTotal ="";

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, tipoCuentaLetra(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.SCIFFSALDO.consultarSaldo");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        saldoDisponible =  resultadoConsulta.get(0).get("sdsdodsp").toString();
        saldoCanje =  resultadoConsulta.get(0).get("sdfltdsp").toString();
        saldoTotal = Double.toString(Double.parseDouble(saldoDisponible) + Double.parseDouble(saldoCanje));
        Serenity.setSessionVariable(SALDOANTES).to(saldoTotal);
    }

    /**
     * Balance deposit after.
     *
     */
    public static void balanceDepositAfter(){
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
        String saldoDisponible ="";
        String saldoCanje ="";
        String saldoTotal ="";

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, tipoCuentaLetra(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.SCIFFSALDO.consultarSaldo");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        saldoDisponible =  resultadoConsulta.get(0).get("sdsdodsp").toString();
        saldoCanje =  resultadoConsulta.get(0).get("sdfltdsp").toString();
        saldoTotal = Double.toString(Double.parseDouble(saldoDisponible) + Double.parseDouble(saldoCanje));
        Serenity.setSessionVariable(SALDODESPUES).to(saldoTotal);
    }

    /**
     * Consultar clave dinamica string.
     *
     * @return the string
     */
    public String consultarClaveDinamica() {
        Usuario user = CargarEntidadUsuario.getUsuario();
        String claveDinamica = "";

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, user.getNumeroDocumento());
        dataForQuery.put(FECHA, DateManager.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("CANAL", CanalesSistemas.BLP);
        dataForQuery.put("HORA", DateManager.obtenerFechaSistema("hhmmss"));
        String sql = QueryManager.CONSULTAS_APP.getString("SQL.PCCFFLGAEN.consultaClaveDinamica");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        claveDinamica =  resultadoConsulta.get(0).get("aenmsgenv").toString();
        return claveDinamica;
    }

    /**
     * Verify topes personalizados pccffppcli boolean.
     *
     * @return the boolean
     */
    public boolean verifyTopesPersonalizadosPCCFFPPCLI() {
        boolean result = false;
        Usuario usuario = CargarEntidadUsuario.getUsuario();

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, usuario.getNumeroDocumento());
        String sql = QueryManager.CONSULTAS_APP.getString("SQL.CABFFTARJ.validarRegistroEprepago");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());

        if (resultadoConsulta != null) {
            result = true;
        }
        return result;
    }

    /**
     * Validate terms and condition boolean.
     *
     * @return the boolean
     */
    public Boolean validateTermsAndCondition() {
        boolean result = false;
        Usuario user = CargarEntidadUsuario.getUsuario();
        TerminosCondiciones terminosCondiciones = CargarEntidadTerminos.getTermsAndConditions();

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(DOCUMENTO, user.getNumeroDocumento());
        String sql = QueryManager.CONSULTAS_APP.getString("SQL.COMFFLGWWW.verificarTerminosyCondiciones");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        String version =  resultadoConsulta.get(0).get("version").toString();
        String fecha =  resultadoConsulta.get(0).get("fecha").toString();
        String fechaSistema = DateManager.obtenerFechaSistema("YYMMdd");

        if (terminosCondiciones.getVersionTermCond().equals(version) && fechaSistema.equals(fecha)) {
            result = true;
        }
        return result;
    }
    
    /**
     * Verify the debit of the balance.
     *
     * @return the boolean
     */
    public static boolean verificarElDebitoDeLaCuenta(){
        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        String valor = CargarEntidadTransferencias.getTransferencias().getAmount();
        String orientacon = configuracionTransaccion.getOrientacionCaso();
        String saldoAntes = Serenity.sessionVariableCalled(SALDOANTES);
        String saldoDespues = Serenity.sessionVariableCalled(SALDODESPUES);
        return validarDebitoDeposito(saldoAntes,saldoDespues,orientacon,valor);
    }
    
    /**
     * Verify the Credit of the balance.
     *
     * @return the boolean
     */
    public static boolean verificarElCreditoDeLaCuenta(){
        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        String valor = CargarEntidadTransferencias.getTransferencias().getAmount();
        String orientacon = configuracionTransaccion.getOrientacionCaso();
        String saldoAntes = Serenity.sessionVariableCalled(SALDOANTES);
        String saldoDespues = Serenity.sessionVariableCalled(SALDODESPUES);
        return validarCreditoDeposito(saldoAntes,saldoDespues,orientacon,valor);
    }
    
    /**
     * Verify the movement of the balance.
     *
     * @return the boolean
     */
    public static String verificarElMovimientoDebitoDeLaCuenta() {
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
        ConfiguracionTransaccion transaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, formatoTipoCuentaNumero(depositos.getTipo()));
        dataForQuery.put(FECHA, DateManager.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("MONTO", CargarEntidadTransferencias.getTransferencias().getAmount());
        dataForQuery.put("NATURALEZA", AdministradorConstante.NATURE_DEBIT);
        dataForQuery.put("HORA", transaccion.getHoraTransaccion());

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.SCIFFMRCMV.MovimientoDeposito");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    /**
     * Verify the movement of the balance.
     *
     * @return the boolean
     */
    public static String verificarElMovimientoCreditoDeLaCuenta() {
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
        ConfiguracionTransaccion transaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, formatoTipoCuentaNumero(depositos.getTipo()));
        dataForQuery.put(FECHA, DateManager.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("MONTO", CargarEntidadTransferencias.getTransferencias().getAmount());
        dataForQuery.put("NATURALEZA", AdministradorConstante.NATURE_CREDIT);
        dataForQuery.put("HORA", transaccion.getHoraTransaccion());

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.SCIFFMRCMV.MovimientoDeposito");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    /**
     * Verifica movtf logtf debito.
     *
     * @return un string
     */
    public static String verificarElDebitoEnMOVTFLOGTF() {
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DIA", DateManager.obtenerFechaSistema("dd"));
        dataForQuery.put("CUENTADEBITO", depositos.getNumero().substring(3,11));
        dataForQuery.put("TIPOCUENTADEBITO", formatoTipoCuentaNumero(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.PCCFFMOVTFLOGTF.consultarRegistroDeb");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    /**
     * Verifica movtf logtf debito.
     *
     * @return un string
     */
    public static String verificarElCreditoEnMOVTFLOGTF() {
        CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
        Map<String, Object> dataForQuery = new HashMap<>();

        dataForQuery.put("DIA", DateManager.obtenerFechaSistema("dd"));
        dataForQuery.put("CUENTACREDITO", depositos.getNumero().substring(3,11));
        dataForQuery.put("TIPOCUENTACREDITO", formatoTipoCuentaNumero(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS_APP.getString("SQL.PCCFFMOVTFLOGTF.consultarRegistroCre");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql,dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    /**
     * Verify channel log Plot 0220 boolean.
     *
     * @return the boolean
     */
    public static List<Map<String, Object>> consultChannelLogPlot220230() {
        Map<String, Object> dataForQuery = new HashMap<>();
        Usuario user = CargarEntidadUsuario.getUsuario();
        ConfiguracionTransaccion datosTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();

        BackTrace backTrace = new BackTrace();
        String trace = "";
        String horaConsulta = "";
        List<Map<String, Object>> listOfFounded = null;
        try {
            horaConsulta = DateManager.obtenerFechaSistema("hhmmss");
            co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
            usuario.setDocumento(user.getNumeroDocumento());
            co.com.bancolombia.backend.modelo.transversal.Transaccion transaccion = new co.com.bancolombia.backend.modelo.transversal.Transaccion();
            transaccion.setCodigoTransaccion(CargarEntidadTransaccion.getConfiguracionTransaccion().getCodigoTransaccion());
            transaccion.setHoraTransaccion(horaConsulta);
            trace = backTrace.consultarTrace(usuario, transaccion, WWW);
            datosTransaccion.setTrace(trace);

            dataForQuery.put("TRACE", trace);
            String sql = QueryManager.CONSULTAS_APP.getString("SQL.COMFFLGWWW.tramaDatos_0220_0230");
            listOfFounded = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return listOfFounded;
    }

    public static boolean validarDebitoDeposito(String saldoAntes, String saldoDespues, String orientacion, String valor) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(valor);
        return "ACIERTO".equalsIgnoreCase(orientacion) ? saldoAnterior.subtract(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }

    public static boolean validarCreditoDeposito(String saldoAntes, String saldoDespues, String orientacion, String valor) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(valor);
        return "ACIERTO".equalsIgnoreCase(orientacion) ? saldoAnterior.add(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }
}

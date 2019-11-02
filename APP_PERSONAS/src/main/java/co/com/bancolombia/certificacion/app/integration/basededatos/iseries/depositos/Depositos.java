package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.depositos;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorFechas;
import co.com.bancolombia.certificacion.app.utilidades.administradores.QueryManager;
import co.com.bancolombia.certificacion.app.utilidades.administradores.StringManager;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import co.com.bancolombia.conexion.basedatos.ConnectionManager;
import co.com.bancolombia.conexion.utilidades.consults.Consulta;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.formatoTipoCuentaNumero;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoCuentaLetra;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.TIENE_PRODUCTOS;

public class Depositos {

    private static final String CUENTA = "CUENTA";
    private static final String TIPOCUENTA = "TIPOCUENTA";
    private static final String SALDOANTES = "saldoDepositoAntes";
    private static final String SALDODESPUES = "saldoDepositoDespues";
    private static final String FECHA = "FECHA";
    private static final String FECHASISTEMA = "yyyyMMdd";

    private Depositos() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

    public static List<Map<String, Object>> saldoDepositosDetalle(Actor actor) {
        Producto depositos = actor.recall(MODELO_DETALLE_PRODUCTO);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero().replace("-", ""));
        dataForQuery.put(TIPOCUENTA, tipoCuentaLetra(depositos.getTipo()));
        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFSALDO.consultarSaldo");
        return Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
    }

    public static List<Map<String, Object>> saldoDepositosConsolidado(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put("DOCUMENTO", StringManager.formatoDocumento(datosPrincipales.getUsuario().getNumeroDocumento()));
        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFSALDO.consultaSaldoPertenenciaCuentaDeposito");
        return Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
    }

    public static void saldoDepositosAntes(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        String saldoDisponible = "";
        String saldoCanje = "";
        String saldoTotal = "";

        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, tipoCuentaLetra(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFSALDO.consultarSaldo");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        saldoDisponible = resultadoConsulta.get(0).get("sdsdodsp").toString();
        saldoCanje = resultadoConsulta.get(0).get("sdfltdsp").toString();
        saldoTotal = Double.toString(Double.parseDouble(saldoDisponible) + Double.parseDouble(saldoCanje));
        Serenity.setSessionVariable(SALDOANTES).to(saldoTotal);
    }

    public static void saldoDepositosDespues(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, tipoCuentaLetra(depositos.getTipo()));

        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFSALDO.consultarSaldo");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        String saldoDisponible = resultadoConsulta.get(0).get("sdsdodsp").toString();
        String saldoCanje = resultadoConsulta.get(0).get("sdfltdsp").toString();
        String saldoTotal = Double.toString(Double.parseDouble(saldoDisponible) + Double.parseDouble(saldoCanje));
        Serenity.setSessionVariable(SALDODESPUES).to(saldoTotal);
    }

    public static boolean verificarElDebitoDeLaCuenta(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        String valor = depositos.getSaldo().getMonto();
        String orientacon = datosPrincipales.getOrientacionCaso();
        String saldoAntes = Serenity.sessionVariableCalled(SALDOANTES);
        String saldoDespues = Serenity.sessionVariableCalled(SALDODESPUES);
        return validarDebitoDeposito(saldoAntes, saldoDespues, orientacon, valor);
    }


    public static boolean verificarElCreditoDeLaCuenta(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        String valor = depositos.getSaldo().getMonto();
        String orientacon = datosPrincipales.getOrientacionCaso();
        String saldoAntes = Serenity.sessionVariableCalled(SALDOANTES);
        String saldoDespues = Serenity.sessionVariableCalled(SALDODESPUES);
        return validarCreditoDeposito(saldoAntes, saldoDespues, orientacon, valor);
    }

    public static String verificarElMovimientoDebitoDeLaCuenta(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, formatoTipoCuentaNumero(depositos.getTipo()));
        dataForQuery.put(FECHA, AdministradorFechas.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("MONTO", depositos.getSaldo().getMonto());
        dataForQuery.put("NATURALEZA", AdministradorConstante.NATURE_DEBIT);
        dataForQuery.put("HORA", datosPrincipales.getHoraTransaccion());

        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFMRCMV.MovimientoDeposito");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
    }

    public static String verificarElMovimientoCreditoDeLaCuenta(Actor actor) {
        Producto depositos = actor.recall(TIENE_PRODUCTOS);
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        Map<String, Object> dataForQuery = new HashMap<>();
        dataForQuery.put(CUENTA, depositos.getNumero());
        dataForQuery.put(TIPOCUENTA, formatoTipoCuentaNumero(depositos.getTipo()));
        dataForQuery.put(FECHA, AdministradorFechas.obtenerFechaSistema(FECHASISTEMA));
        dataForQuery.put("MONTO", depositos.getSaldo().getMonto());
        dataForQuery.put("NATURALEZA", AdministradorConstante.NATURE_CREDIT);
        dataForQuery.put("HORA", datosPrincipales.getHoraTransaccion());

        String sql = QueryManager.CONSULTAS.getString("SQL.SCIFFMRCMV.MovimientoDeposito");
        List<Map<String, Object>> resultadoConsulta = Consulta.ejecutar(sql, dataForQuery, ConnectionManager.getIseriesConnection());
        return resultadoConsulta.get(0).toString();
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

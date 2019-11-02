package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;

import java.util.ResourceBundle;


/**
 * The Class QueryManager.
 *
 * @author Oscar Armando Vallejo Tovar
 */
public class QueryManager {

    /**
     * The Constant ISERIES.
     */
    public static final ResourceBundle ISERIES = ResourceBundle.getBundle("consultasIseries");
    /**
     * The Constant ISERIES_TOPES.
     */
    public static final ResourceBundle ISERIES_TOPES = ResourceBundle.getBundle("consultasIseriesTopes");
    /**
     * The Constant ISERIES_TOPES.
     */
    public static final ResourceBundle ISERIES_ALERTAS = ResourceBundle.getBundle("consultasIseriesAlertas");
    /**
     * The Constant ISERIES_TOPES.
     */
    public static final ResourceBundle ISERIES_LOGCANAL = ResourceBundle.getBundle("consultasIseriesLogCanal");
    /**
     * The Constant EXCEL.
     */
    public static final ResourceBundle EXCEL = ResourceBundle.getBundle("consultasExcel");
    /**
     * The constantes CLOUDANT.
     */
    public static final ResourceBundle CLOUDANT = ResourceBundle.getBundle("consultasCloudant");
    /**
     * The constantes CONSULTAS_APP.
     */
    public static final ResourceBundle CONSULTAS_APP = ResourceBundle.getBundle("consultasApp");

    /**
     * The constantes ISERIES_AHORRO_CON_PROPOSITO.
     */
    public static final ResourceBundle ISERIES_AHORRO_CON_PROPOSITO = ResourceBundle.getBundle("consultaIseriesAhorroConProposito");

    /**
     * The constantes ISERIES_MERCADO_LIBRE_DIVISAS.
     */
    public static final ResourceBundle ISERIES_MERCADO_LIBRE_DIVISAS = ResourceBundle.getBundle("consultasIseriesMercadoLibreDivisas");

    /**
     * The constantes ISERIES_PSE.
     */
    public static final ResourceBundle ISERIES_PSE = ResourceBundle.getBundle("consultasIseriesPse");

    /**
     * The constantes CONSULTAS_CANALES.
     */
    public static final ResourceBundle CONSULTAS_CANALES = ResourceBundle.getBundle("consultasCanales");
    /**
     * The Constant ISERIES_BATCH.
     */
    public static final ResourceBundle ISERIES_BATCH = ResourceBundle.getBundle("consultasIseriesBatch");
    /**
     * Instantiates a new query manager.
     */
    /**
	 * The Constant ISERIES_FONDOS.
	 */
	public static final ResourceBundle ISERIES_FONDOS = ResourceBundle.getBundle("consultasIseriesFondos");
    /**
     * The Constant ORACLE_BATCH.
     */
    public static final ResourceBundle ORACLE_BATCH = ResourceBundle.getBundle("consultasOracle");
	
    private QueryManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }
}

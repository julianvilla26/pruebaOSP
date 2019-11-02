package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;

import java.util.ResourceBundle;

public class QueryManager {
    public static final ResourceBundle CONSULTAS = ResourceBundle.getBundle("queries/iseries/consultas");
    public static final ResourceBundle ORACLE_BATCH = ResourceBundle.getBundle("queries/oracle/consultasOracle");

    private QueryManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }
}

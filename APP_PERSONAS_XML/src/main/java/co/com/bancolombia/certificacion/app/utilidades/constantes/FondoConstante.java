package co.com.bancolombia.certificacion.app.utilidades.constantes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Constant found.
 */
public class FondoConstante {

    /**
     * The constantes LIBRARY_BY_CODE.
     */
    public static final Map<String, String> LIBRARY_BY_CODE;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("ALTERNATIVO DINAMICO", "FAD");
        map.put("FIDURENTA", "F16");
        map.put("R18", "RENTA FIJA PLAZO");
        map.put("FIDUCUENTA", "F01");
        map.put("FAS", "ACCIONES SECTORIAL");
        map.put("FAU", "FONDO ACCIONES UNIACCION");
        map.put("FIE", "FIDUEXCEDENTES");
        map.put("FXP", "C.C.A.P.P. INDEXADO ACCIONES");
        map.put("RTE", "RENTA TES");
        map.put("RUS", "RENTA DOLARES");
        map.put("FONDO RENTA BALANCEADO", "085");
        map.put("RAC", "RENTA ACCIONES");
        map.put("FIN", "INDECCION");
        map.put("104", "104");
        LIBRARY_BY_CODE = Collections.unmodifiableMap(map);
    }

    private FondoConstante() {
        throw new IllegalStateException(TipoClaseConstante.CONSTANT_CLASS);
    }

}

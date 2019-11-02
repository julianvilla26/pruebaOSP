package co.com.bancolombia.certificacion.app.utilidades.constantes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_CONSTANTE;

public class FondoLibrerias {

    public static final Map<String, String> BIBLIOTECA_POR_CODIGO;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("FIDUCUENTA", "FIDLIBC1MD");
        map.put("FIDURENTA", "FIDLIBC7MD");
        map.put("RENTA FIJA PLAZO", "FIDLIBC7MD");
        map.put("RENTA BALANCEADA", "FIDLIBC6MD");
        map.put("RENTA ACCIONES", "FIDLIBC6MD");
        map.put("PLAN SEMILLA", "FIDLIBC4MD");
        BIBLIOTECA_POR_CODIGO = Collections.unmodifiableMap(map);
    }

    private FondoLibrerias() {
        throw new IllegalStateException(CLASE_CONSTANTE);
    }

}

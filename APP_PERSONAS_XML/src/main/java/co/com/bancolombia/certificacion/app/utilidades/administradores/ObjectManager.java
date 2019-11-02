package co.com.bancolombia.certificacion.app.utilidades.administradores;

import co.com.bancolombia.backend.modelo.productos.TarjetaCredito;
import co.com.bancolombia.backend.modelo.transversal.Tef;
import co.com.bancolombia.backend.utilidades.constant.ConstantManager;
import co.com.bancolombia.backend.utilidades.enums.CodigosExcepciones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Objects;


/**
 * The type Object manager.
 */
public class ObjectManager {

    private static final Logger LOGGER = LogManager.getLogger(ConstantManager.TEF);

    private ObjectManager() {
        throw new IllegalStateException(CodigosExcepciones.UTILITY_CLASS.getMsg());
    }

    /**
     * Difference list.
     *
     * @param tef1 the s 1
     * @param tef2 the s 2
     * @throws IllegalAccessException the illegal access exception
     */
    public static void diferenciasTef(Tef tef1, Tef tef2) throws IllegalAccessException {
        for (Field field : tef1.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value1 = field.get(tef1);
            Object value2 = field.get(tef2);
            buscarDiferencias(value1, value2);
        }
    }

    private static void buscarDiferencias(Object value1, Object value2) {
        if ((value1 != null && value2 != null) && !Objects.equals(value1, value2)) {
            String valor1 = StringManager.reemplazarModeloDatos(value1.toString());
            String valor2 = StringManager.reemplazarModeloDatos(value2.toString());
            LOGGER.info("Diferencias en el Tef \nOBJETO ESPERADO \n{} \nOBJETO OBTENIDO \n{}", valor1, valor2);
        }
    }

    public static void diferenciasTefTarjetascredito(TarjetaCredito tarjetaCreditoEsperado, TarjetaCredito tarjetaCreditoObtenido) throws IllegalAccessException {
        for (Field field : tarjetaCreditoEsperado.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value1 = field.get(tarjetaCreditoEsperado);
            Object value2 = field.get(tarjetaCreditoObtenido);
            buscarDiferencias(value1, value2);
        }
    }
}

package co.com.bancolombia.certificacion.app.models.entidades.eprepago;

import co.com.bancolombia.backend.modelo.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades;

import java.util.List;

/**
 * The type Create deposit entity.
 */
public class CreateDepositEntity {
    private static CuentaDeposito depositValues;

    private CreateDepositEntity() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Gets deposit values.
     *
     * @return the deposit values
     */
    public static CuentaDeposito getDepositValues() {
        return depositValues;
    }

    /**
     * Sets deposit values.
     *
     * @param data the data
     */
    public static void setDepositValues(List<String> data) {
        CuentaDeposito depositValues = new CuentaDeposito();
        depositValues.setNumero(data.get(0));
        depositValues.setTipo(data.get(1));
        depositValues.setTipoNum(AdministradorUtilidades.formatoTipoCuentaNumero(data.get(1)));
        CreateDepositEntity.depositValues = depositValues;
    }
}

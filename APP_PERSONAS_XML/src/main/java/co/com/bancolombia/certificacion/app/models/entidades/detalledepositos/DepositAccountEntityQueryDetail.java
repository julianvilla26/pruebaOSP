package co.com.bancolombia.certificacion.app.models.entidades.detalledepositos;


import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Detail query deposit account entity.
 */
public class DepositAccountEntityQueryDetail {

    private static CuentaDeposito depositAccount = new CuentaDeposito();

    private DepositAccountEntityQueryDetail() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets detalle consulta cuenta deposito.
     *
     * @return the detalle consulta cuenta deposito
     */
    public static CuentaDeposito getDepositAccount() {
        return depositAccount;
    }

    /**
     * Sets detalle consulta cuenta deposito.
     *
     * @param data the data
     */
    public static void setDepositAccount(List<String> data) {
        depositAccount.setAccountNumberFormat(data.get(0));
        depositAccount.setTipo(data.get(1));

    }


}

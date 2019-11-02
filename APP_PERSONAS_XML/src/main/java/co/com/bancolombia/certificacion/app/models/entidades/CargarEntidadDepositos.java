package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencias;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Current Deposito entity.
 */

public class CargarEntidadDepositos {

    private static CuentaDeposito deposito = new CuentaDeposito();
    private CargarEntidadDepositos() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets deposit.
     *
     * @return  deposit
     */
    public static CuentaDeposito getCuentaDeposito() {
        return deposito;
    }

    /**
     * Sets deposit.
     *
     * @param data the data
     */
    public static void conEstos(List<String> data){
        Transferencias transferencias = CargarEntidadTransferencias.getTransferencias();
        deposito.setNumero(data.get(0));
        deposito.setTipo(data.get(1));
        transferencias.setAmount(data.get(2));
    }
}

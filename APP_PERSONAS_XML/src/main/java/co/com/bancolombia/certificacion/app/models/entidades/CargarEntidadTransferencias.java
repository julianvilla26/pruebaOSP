package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.factoria.FactoriaProducto;
import co.com.bancolombia.certificacion.app.models.factoria.FactoriaProductoMetodo;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencias;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante.TRANSACTION_CODE_ACH;


/**
 * The type Current transferencias entity.
 */
public class CargarEntidadTransferencias {
    private static Transferencias transferencias = new Transferencias();

    private CargarEntidadTransferencias() {

    }

    /**
     * Gets transferencias.
     *
     * @return the transferencias
     */
    public static Transferencias getTransferencias() {
        return transferencias;
    }

    /**
     * Sets transferencias.
     *
     * @param data the data
     */
    public static void setTransferencias(List<String> data) {
        Transferencias transferencias = new Transferencias();
        FactoriaProductoMetodo productFactory = new FactoriaProducto();

        Producto originProduct = productFactory.createProduct(data.get(0), data.get(1));
        Producto destinationProduct = productFactory.createProduct(data.get(2), data.get(3));
        transferencias.setOriginProduct(originProduct);
        transferencias.setDestinationProduct(destinationProduct);
        transferencias.setAmount(data.get(4));

        if (CargarEntidadTransaccion.getConfiguracionTransaccion().getCodigoTransaccion().equals(TRANSACTION_CODE_ACH)) {
            transferencias.setBank(data.get(5));
            transferencias.setDescription(data.get(6));
            transferencias.setAdditionalInformation(data.get(7));
        }
        
        CargarEntidadTransferencias.transferencias = transferencias;
    }

}

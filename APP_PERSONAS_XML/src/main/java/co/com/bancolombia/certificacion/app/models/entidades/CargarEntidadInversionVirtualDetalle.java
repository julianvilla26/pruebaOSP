package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.productos.InversionVirtual;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Virtual investment detail entity.
 */
public class CargarEntidadInversionVirtualDetalle {

    private static InversionVirtual virtualInvestmentDetail = new InversionVirtual();

    private CargarEntidadInversionVirtualDetalle() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets detalle inversion virtual.
     *
     * @return the detalle inversion virtual
     */
    public static InversionVirtual getVirtualInvestmentDetail() {
        return virtualInvestmentDetail;
    }

    /**
     * Sets detalle inversion virtual.
     *
     * @param data the data
     */
    public static void setVirtualInvestmentDetail(List<String> data) {
        virtualInvestmentDetail.setInvestmentNumber(data.get(0));
    }
}

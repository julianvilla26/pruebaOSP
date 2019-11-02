package co.com.bancolombia.certificacion.app.models.entidades.eprepago;

import co.com.bancolombia.certificacion.app.models.productos.EPrepago;

import java.util.List;

/**
 * The type Create movements e prepago entity.
 */
public class CreateMovementsEPrepagoEntity {
    private static EPrepago ePrepagoMovements;

    private CreateMovementsEPrepagoEntity() {
    }

    /**
     * Gets movements e prepago.
     *
     * @return the movements e prepago
     */
    public static EPrepago getMovementsEPrepago() {
        return ePrepagoMovements;
    }

    /**
     * Sets movements e prepago.
     *
     * @param data the data
     */
    public static void setMovementsEPrepago(List<String> data) {
        EPrepago ePrepagoMovements = new EPrepago();
        ePrepagoMovements.setMovementDescription(data.get(0));
        ePrepagoMovements.setDatefrom(data.get(1));
        ePrepagoMovements.setDateto(data.get(2));
        CreateMovementsEPrepagoEntity.ePrepagoMovements = ePrepagoMovements;
    }
}

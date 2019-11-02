package co.com.bancolombia.certificacion.app.models.entidades.eprepago;

import co.com.bancolombia.certificacion.app.models.productos.EPrepago;

import java.util.List;

/**
 * The type Create terms and conditions entity.
 */
public class CreateTermsAndConditionsEntity {

    private static EPrepago ePrepagoValues;

    private CreateTermsAndConditionsEntity() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Gets ty ce prepago.
     *
     * @return the ty ce prepago
     */
    public static EPrepago getTyCEPrepago() {
        return ePrepagoValues;
    }

    /**
     * Sets ty ce prepago.
     *
     * @param versionTyC the version ty c
     */
    public static void setTyCEPrepago(List<String> versionTyC) {
        EPrepago ePrepagoValues = new EPrepago();
        ePrepagoValues.setTyc(versionTyC.get(0));
        CreateTermsAndConditionsEntity.ePrepagoValues = ePrepagoValues;
    }

}

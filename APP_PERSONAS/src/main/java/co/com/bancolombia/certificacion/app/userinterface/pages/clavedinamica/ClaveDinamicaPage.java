package co.com.bancolombia.certificacion.app.userinterface.pages.clavedinamica;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.clavedinamica.ClaveDinamicaLocator.LBL_CLAVE_DINAMICA_GENERADA_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;

public class ClaveDinamicaPage {
    public static final Target LBL_CLAVE_DINAMICA_GENERADA = Target.the("Label de Clave Dinamica generada automaticamente").locatedBy(dynamicElement(LBL_CLAVE_DINAMICA_GENERADA_LOCATOR));

    private ClaveDinamicaPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

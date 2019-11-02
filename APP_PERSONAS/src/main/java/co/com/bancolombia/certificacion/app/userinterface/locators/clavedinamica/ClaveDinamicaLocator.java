package co.com.bancolombia.certificacion.app.userinterface.locators.clavedinamica;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class ClaveDinamicaLocator {
    public static final Locator LBL_CLAVE_DINAMICA_GENERADA_LOCATOR = locator().withAndroid("xpath$//div[contains(@id,'Title') and contains(.,'{0}')]/following-sibling::div/span").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText");

    private ClaveDinamicaLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}

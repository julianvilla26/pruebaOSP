package co.com.bancolombia.certificacion.app.userinterface.locators.crediagil;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class CrediagilLocator {
    public static final Locator TXT_VALOR_DESEMBOLSAR_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Value']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa el valor a desembolsar']]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField");
    public static final Locator FOCO_LOCATOR = locator().withAndroid("xpath$//span[text()='Crediágil']").withIos("xpath$//XCUIElementTypeStaticText[@name='Crediágil']");
    public static final Locator BTN_DESEMBOLSAR_LOCATOR = locator().withAndroid("xpath$//button[./span[text()='DESEMBOLSAR']]").withIos("xpath$//XCUIElementTypeButton[@name='DESEMBOLSAR']");
    public static final Locator TXT_PRODUCTO_DESTINO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),{0})]").withIos("xpath$//*[@name='{0}']");
    public static final Locator TXT_VALOR_DESEMBOLSADOR_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),{0})]").withIos("xpath$//*[@name='{0}']");
    public static final Locator TXT_DESEMBOLSO_EXITOSO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'¡Desembolso exitoso!')]").withIos("xpath$//*[@name='¡Desembolso exitoso!']");
    public static final Locator TXT_FUERA_RANGO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'Ingresa un valor entre')]").withIos("xpath$//*[contains(@name,'Ingresa un valor entre')]");

    private CrediagilLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}

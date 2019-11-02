package co.com.bancolombia.certificacion.app.userinterface.locators.transferencia;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class TransferenciaLocator {
    public static final Locator TXT_VALOR_TRANSFERENCIA_LOCATOR = locator().withAndroid("xpath$//div[contains(@id,'MaskedContent')]//input[@id='Currency']").withIos("xpath$//XCUIElementTypeStaticText[@name='Ingresa el valor a enviar']/../following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator TXT_FOCO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'TRANSFERIR')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'TRANSFERIR')]");
    public static final Locator TXT_NUMERO_CUENTA_DESTINO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_ProductNumber']").withIos("xpath$//XCUIElementTypeStaticText[@value='Ingresa el número del producto']/../../following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator BTN_ENVIAR_DINERO_LOCATOR = locator().withAndroid("xpath$//span[text()='ENVIAR DINERO']/..").withIos("xpath$//XCUIElementTypeButton[@name='ENVIAR DINERO']");
    public static final Locator LBL_TRANFERENCIA_EXITOSA_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Transferencia realizada!' or text()='¡Transferencia exitosa!']").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Transferencia realizada!' or @name='¡Transferencia exitosa!']");
    public static final Locator LBL_CUENTA_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']/../following-sibling::div//span[contains(text(),'{1}')]").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[@name='{1}']");
    public static final Locator BTN_INVERSIONES_LOCATOR = locator().withAndroid("xpath$//span[text()='Inversiones']").withIos("xpath$//XCUIElementTypeStaticText[@name='Inversiones']");
    public static final Locator BTN_CUENTAS_LOCATOR = locator().withAndroid("xpath$//span[text()='Cuentas']").withIos("xpath$//XCUIElementTypeStaticText[@name='Cuentas']");
    public static final Locator LBL_VALOR_LOCATOR = locator().withAndroid("xpath$//span[text()='Valor enviado']/../following-sibling::div/span[contains(text(),'{0}')]").withIos("xpath$//XCUIElementTypeStaticText[@name='Valor enviado']/../following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeStaticText[contains(@name,'{0}')]");
    public static final Locator BTN_TIPO_PRODUCTO_DESTINO_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator BTN_PRODUCTO_INSCRITO_LOCATOR = locator().withAndroid("xpath$(//span[text()='{0}'])[2]").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}' and @visible='true']");

    private TransferenciaLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
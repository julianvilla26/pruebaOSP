package co.com.bancolombia.certificacion.app.userinterface.locators.eprepago;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class DescargarTarjetaVirtualEprepagoLocator {
    public static final Locator BTN_DESCARGAR_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Descargar']").withIos("xpath$//XCUIElementTypeStaticText[@name='Descargar']/..");
    public static final Locator LNK_DESCARGAR_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Descargar']").withIos("xpath$//XCUIElementTypeButton[@name='DESCARGAR']");
    public static final Locator CHK_DESCARGA_TOTAL_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Total']/preceding-sibling::button").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Total']]/preceding-sibling::XCUIElementTypeButton[1]");
    public static final Locator CHK_DESCARGA_OTRO_VALOR_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Otro valor']/preceding-sibling::button").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Otro valor']]/preceding-sibling::XCUIElementTypeButton[1]");
    public static final Locator LBL_PRODUCTO_DESTINO_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Producto destino']").withIos("xpath$//XCUIElementTypeStaticText[@name='Producto destino']");
    public static final Locator LBL_DESCARGA_EXITOSA_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Descarga exitosa!']").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Descarga exitosa!']");
    public static final Locator LBL_VALOR_DESCARGA_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'{0}')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'{0}')]");
    public static final Locator TXT_VALOR_DESCARGA_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//div[contains(@id,'MaskedContent')]/descendant::input").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa el valor a descargar']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator FOCO_LOCATOR = locator().withAndroid("xpath$//*[text()='Selecciona el valor']").withIos("xpath$//XCUIElementTypeStaticText[@name='Selecciona el valor']");

    private DescargarTarjetaVirtualEprepagoLocator(){throw new IllegalStateException(CLASE_LOCATOR);}
}
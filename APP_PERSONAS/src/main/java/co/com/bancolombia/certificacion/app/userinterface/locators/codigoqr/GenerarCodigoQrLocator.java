package co.com.bancolombia.certificacion.app.userinterface.locators.codigoqr;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class GenerarCodigoQrLocator {
    public static final Locator TXT_NOMBRE_PERSONALIZADO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Personal_Name']").withIos("xpath$//XCUIElementTypeStaticText[@name='Ingresa un nombre personalizado']/../following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator TXT_VALOR_RECIBIR_LOCATOR = locator().withAndroid("xpath$//span[text()='Ingresa el valor a recibir']/../following-sibling::div//span[@class='input-tel']/input").withIos("xpath$//XCUIElementTypeStaticText[@value='Ingresa el valor a recibir']/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator BTN_CON_VALOR_LOCATOR = locator().withAndroid("xpath$//span[text()='Con Valor']/preceding-sibling::button").withIos("xpath$//XCUIElementTypeStaticText[@value='Con Valor']/../preceding-sibling:: XCUIElementTypeButton[1]");
    public static final Locator BTN_SIN_VALOR_LOCATOR = locator().withAndroid("xpath$//span[text()='Sin valor']/preceding-sibling::button").withIos("xpath$//XCUIElementTypeStaticText[@value='Sin valor']/../preceding-sibling:: XCUIElementTypeButton[1]");
    public static final Locator TXT_DESCRIPCION_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Reference']").withIos("xpath$//XCUIElementTypeStaticText[@value='Ingresa una referencia (Opcional)']/../following-sibling:: XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    public static final Locator BTN_GENERAR_QR_LOCATOR = locator().withAndroid("xpath$//span[text()='GENERAR QR']/..").withIos("xpath$//XCUIElementTypeButton[@name='GENERAR QR']");
    public static final Locator IMG_CODIGO_QR_LOCATOR = locator().withAndroid("xpath$//img[@alt='Scan me!']").withIos("xpath$//XCUIElementTypeImage[@name='Scan me!']");
    public static final Locator IMG_CODIGO_QR_PANTALLA_INICIO_LOCATOR = locator().withAndroid("xpath$//div[contains(@id,'FloatingIcon')]/img").withIos("xpath$//XCUIElementTypeOther[contains(@name,'QR')]/..");
    public static final Locator IMG_CODIGO_QR_FLOTANTE_LOCATOR = locator().withAndroid("xpath$//div[@class='floating-actions-items OSInline']/div[3]//img").withIos("xpath$//XCUIElementTypeLink[@name='Generar código QR']/following-sibling:: XCUIElementTypeOther[1]");
    public static final Locator TXT_NUMERO_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//input[@id='CreditCard']").withIos("xpath$//XCUIElementTypeStaticText[@name='Ingresa el número del producto']/../following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator BTN_TIPO_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'{0}')]/preceding-sibling::button").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../preceding-sibling::XCUIElementTypeButton[1]");

    private GenerarCodigoQrLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}

package co.com.bancolombia.certificacion.app.userinterface.locators.registro;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class InscripcionProductoLocator {
    public static final Locator TXT_BANCO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_BankName2']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Selecciona el banco']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    public static final Locator TXT_NUMERO_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_usuario3']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa el número del producto']]/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    public static final Locator TXT_BUSCAR_NOMBRE_BANCO_LOCATOR = locator().withAndroid("xpath$//input[contains(@id,'Input_SearchParameter')]").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Selecciona el banco']]/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeSearchField");
    public static final Locator ITEM_NOMBRE_BANCO_LOCATOR = locator().withAndroid("xpath$//div[contains(@id,'SearchResult')]/div/div[1]/span").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Buscar']]/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator CHK_TIPO_CUENTA_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']/../button").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='{0}']]/preceding-sibling:: XCUIElementTypeButton[1]");
    public static final Locator TXT_TIPO_DOCUMENTO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_BankName3']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Selecciona el tipo de documento']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeImage");
    public static final Locator TXT_NUMERO_DOCUEMENTO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_DocumentNumber']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa el número del documento']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator ITEM_TIPO_DOCUMENTO_LOCATOR = locator().withAndroid("xpath$//div[@id='AccountOptions']//div//span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator BTN_INSCRIBIR_LOCATOR = locator().withAndroid("xpath$//span[text()='INSCRIBIR']/..").withIos("xpath$//XCUIElementTypeButton[@name='INSCRIBIR']");
    public static final Locator BTN_CERRAR_SELECCION_BANCO_LOCATOR = locator().withAndroid("xpath$//div[./div/div/div/span[contains(text(),'Selecciona el banco')]]/following-sibling::div//span[text()='CERRAR']/..").withIos("xpath$(//XCUIElementTypeStaticText[@name='CERRAR'])[1]");
    public static final Locator IMG_CONFIRMACION_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Inscripción pendiente de activación!']").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Inscripción pendiente de activación!']");
    public static final Locator LBL_TIPO_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//span[text()='Tipo de producto']/../../span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_BANCO_LOCATOR = locator().withAndroid("xpath$//span[text()='Banco']/../../span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_TIPO_DOCUMENTO_LOCATOR = locator().withAndroid("xpath$//span[text()='Tipo de documento']/../../span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_NUMERO_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//span[text()='Número de producto']/../../span[1]").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_NUMERO_DOCUMENTO_LOCATOR = locator().withAndroid("xpath$//span[text()='Número de documento']/../../span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']");
    public static final Locator LBL_CUENATA_PENDIENTE_CONFIRMACION_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']").withIos("xpath$//*[@name='{0}']");
    public static final Locator FOCO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Datos')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'Datos')]");

    private InscripcionProductoLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
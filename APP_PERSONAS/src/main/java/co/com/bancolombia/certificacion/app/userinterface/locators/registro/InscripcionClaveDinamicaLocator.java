package co.com.bancolombia.certificacion.app.userinterface.locators.registro;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class InscripcionClaveDinamicaLocator {
    public static final Locator TXT_NOMBRE_PERSONALIZADO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_CustomNameNew']").withIos("xpath$//XCUIElementTypeStaticText[@name='Ingresa un nombre personalizado']/..//following::XCUIElementTypeOther[1]");
    public static final Locator TXT_CORREO_CLAVE_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Email']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[contains(@name,'correo electrónico')]]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator CHK_TIPO_CORREO_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']/preceding-sibling::button").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/../preceding-sibling::XCUIElementTypeButton[1]");
    public static final Locator TXT_NUMERO_CELULAR_LOCATOR= locator().withAndroid("xpath$//input[@id='Input_PhoneNumber_VerifyPhoneDK']").withIos("xpath$//XCUIElementTypeOther[@name='Editar']/preceding-sibling::XCUIElementTypeTextField");
    public static final Locator CHK_ACEPTO_TERMINOS_LOCATOR= locator().withAndroid("xpath$//input[@id='Checkbox_AcceptTermsConditions_VerifyPhoneDK']").withIos("xpath$//XCUIElementTypeOther[@name='Editar']//parent::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeSwitch");
    public static final Locator CHK_FOCO_ACEPTO_LOCATOR= locator().withAndroid("xpath$//input[@id='Input_Email']/../..//div").withIos("xpath$//XCUIElementTypeStaticText[@name='Correo electrónico']");
    public static final Locator TXT_FOCO_NOMBRE_PERSONALIZADO_LOCATOR= locator().withAndroid("xpath$//span[contains(text(),'Nombre') and @class='black-title-text']").withIos("xpath$//XCUIElementTypeStaticText[@name='Te ayudará a identificar la clave dinámica']");
    public static final Locator BTN_INSCRIBIR_CLAVE_LOCATOR= locator().withAndroid("xpath$//span[text()='Inscribir']/../..").withIos("xpath$//XCUIElementTypeStaticText[@name='Inscribir']");
    public static final Locator TXT_SEGUNDA_CLAVE_LOCATOR= locator().withAndroid("xpath$//div[@class='col OSInline' and @id='b12-Column2']").withIos("xpath$//XCUIElementTypeStaticText[@name='Ingresa la segunda clave']/..//following-sibling::XCUIElementTypeOther[1]");
    public static final Locator BTN_INSCRIBIR_CLAVE_DINAMICA_LOCATOR= locator().withAndroid("xpath$//android.view.View[@resource-id='Link_LemonEnroll_GetDK2']").withIos("xpath$test");
    public static final Locator BTN_CONTINUAR_SEGUNDA_CLAVE_LOCATOR = locator().withAndroid("xpath$//button[@id='Button_Continuar']").withIos("xpath$//XCUIElementTypeButton[@name='CONTINUAR']");
    public static final Locator LBL_COMPROBANTE_CLAVE_DINAMICA_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'Comprobante')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'Comprobante')]");
    public static final Locator LBL_ACTUALIZACION_EXITOSA_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'¡Actualización exitosa!')]").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Actualización exitosa!']");
    public static final Locator LNK_ELIMINAR_CLAVE_DINAMICA_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']/../../following-sibling::div//span[text()='Eliminar']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/..//following-sibling::XCUIElementTypeLink[1]");
    public static final Locator BTN_ELIMINAR_CLAVE_DINAMICA_LOCATOR = locator().withAndroid("xpath$//button[text()='ELIMINAR']").withIos("xpath$//XCUIElementTypeButton[@name='ELIMINAR']");
    public static final Locator LBL_VERIFICACION_ELIMINAR_CLAVE_DINAMICA_LOCATOR = locator().withAndroid("xpath$//span[text()='Clave dinámica eliminada']/../following-sibling::div//span[text()='{0}']").withIos("xpath$//XCUIElementTypeStaticText[@name='{0}']/..//preceding-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText");
    public static final Locator LBL_VERIFICACION_MENSAJE_CLAVE_DINAMICA_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Eliminación exitosa!']").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Eliminación exitosa!']");
    public static final Locator FOCO_INSCRIPCION_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'INSCRIBIR')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'INSCRIBIR')]");

    private InscripcionClaveDinamicaLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
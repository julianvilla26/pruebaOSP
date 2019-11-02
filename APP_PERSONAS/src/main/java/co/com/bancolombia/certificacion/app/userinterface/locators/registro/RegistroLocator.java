package co.com.bancolombia.certificacion.app.userinterface.locators.registro;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class RegistroLocator {
    public static final Locator TXT_CREAR_USUARIO_LOCATOR = locator().withAndroid("id$Input_usuario2").withIos("xpath$//XCUIElementTypeOther[@name='Iconografia/accionables/Usuario']/..");
    public static final Locator TXT_CORREO_LOCATOR = locator().withAndroid("id$TextArea_CorreoElectronico").withIos("xpath$//XCUIElementTypeStaticText[@value='Ingresa el correo electrónico']/../following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeTextField");
    public static final Locator LBL_CORREO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Correo electrónico')]").withIos("xpath$//XCUIElementTypeStaticText[@name='Correo electrónico']");
    public static final Locator LBL_TIPO_CORREO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Selecciona el tipo de correo')]").withIos("xpath$//XCUIElementTypeStaticText[@name='Selecciona el tipo de correo']");
    public static final Locator CHECK_TIPO_CORREO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Personal')]//following::button[1]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name, 'Personal')]/../../XCUIElementTypeButton[1]//following-sibling::XCUIElementTypeButton[1]");
    public static final Locator CHECK_TYC_LOCATOR = locator().withAndroid("id$Chk_TerminosCondiciones").withIos("xpath$//XCUIElementTypeStaticText[@name='Laboral']//following::XCUIElementTypeSwitch[1]");
    public static final Locator BTN_REGISTRO_LOCATOR = locator().withAndroid("xpath$//span[contains(.,'REGISTRAR')]/ancestor::button").withIos("xpath$//XCUIElementTypeButton[contains(@name,'REGISTRAR')]");
    public static final Locator LBL_VALIDACION_REGISTRO_OK_LOCATOR = locator().withAndroid("xpath$//*[contains(.,'¡Registro exitoso!')]").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Registro exitoso!']");
    public static final Locator LBL_INICIA_REGISTRO_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Inicia el registro')]").withIos("xpath$//XCUIElementTypeStaticText[contains(@name,'Inicia el registro')]");

    private RegistroLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
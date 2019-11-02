package co.com.bancolombia.certificacion.app.userinterface.locators.autenticacion;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class InicioSesionLocator {
    public static final Locator BTN_INGRESAR_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'INGRESAR')]").withIos("xpath$//XCUIElementTypeButton[contains(@name,'INGRESAR')]");
    public static final Locator TXT_USUARIO_LOCATOR = locator().withAndroid("id$Input_Username_UserAuth").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Hola!']/..//following-sibling::XCUIElementTypeOther[3]");
    public static final Locator BTN_CONTINUAR_LOCATOR = locator().withAndroid("id$Button_Continue_UserAuth").withIos("xpath$//XCUIElementTypeButton[@name='CONTINUAR']");
    public static final Locator LBL_HOLA_PROVIVIONAL_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'Hola')]").withIos("xpath$//XCUIElementTypeStaticText[@name='¡Hola!']");
    public static final Locator TXT_CLAVE_DIGITOS_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_TextVar']").withIos("xpath$//XCUIElementTypeOther[@name='Ingreso de la clave']/XCUIElementTypeOther[9]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]");
    public static final Locator TAB_LOCATOR = locator().withAndroid("xpath$test").withIos("xpath$//XCUIElementTypeOther/XCUIElementTypeTextField");
    public static final Locator TXT_SEGUNDA_CLAVE_DIGITOS_LOCATOR = locator().withAndroid("xpath$//div[contains(@id, 'Column1')]//span[1]").withIos("xpath$//XCUIElementTypeOther[@name='Ingreso de la clave']/XCUIElementTypeOther[9]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]");
    public static final Locator LBL_CLAVE_INVALIDA_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'CLAVE NO VALIDA')]").withIos("xpath$//XCUIElementTypeStaticText[@name='CLAVE NO VALIDA']");
    public static final Locator LBL_USER_YA_REGISTRADO_LOCATOR = locator().withAndroid("xpath$//div[contains(@id, 'Icon')]/../following-sibling::div//span[contains(.,'Usuario o clave inválida. Inténtalo nuevamente.')]").withIos("xpath$//XCUIElementTypeStaticText[@name='Usuario o clave inválida. Inténtalo nuevamente.']");
    public static final Locator BTN_CERRAR_MODAL_CLAVE_NO_VALIDA_LOCATOR = locator().withAndroid("xpath$//*[contains(@id,'IconClose')]/child::div[1]").withIos("xpath$test");
    public static final Locator BTN_CERRAR_SESION_LOCATOR = locator().withAndroid("id$Next").withIos("xpath$//XCUIElementTypeButton[contains(@name,'CERRAR SESIÓN')]");
    public static final Locator BTN_SI_CERRAR_SESION_LOCATOR = locator().withAndroid("id$Button_CancelYesModal_ActivateBiometrics").withIos("xpath$//XCUIElementTypeButton[@name='SI']");
    public static final Locator BTN_FOCO_CERRAR_SESION_LOCATOR = locator().withAndroid("id$Button_CancelYesModal_ActivateBiometrics").withIos("xpath$//XCUIElementTypeStaticText[@name='¿Quieres cerrar sesión?']");
    public static final Locator BTN_VOLVER_LOCATOR = locator().withAndroid("xpath$//span[text()='Volver']").withIos("xpath$//XCUIElementTypeLink[contains(@name,'Volver')]");
    public static final Locator LBL_CLAVE_BLOQUEADA_LOCATOR = locator().withAndroid("xpath$//*[contains(text(),'CLAVE BLOQUEADA')]").withIos("xpath$//XCUIElementTypeStaticText[@name='CLAVE BLOQUEADA']");

    private InicioSesionLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
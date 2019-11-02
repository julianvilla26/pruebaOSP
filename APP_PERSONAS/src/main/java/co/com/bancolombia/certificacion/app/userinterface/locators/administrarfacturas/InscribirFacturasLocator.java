package co.com.bancolombia.certificacion.app.userinterface.locators.administrarfacturas;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class InscribirFacturasLocator {
    public static final Locator BTN_INCRIBIR_MANUALMENTE_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'manualmente')]/..").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Inscribir']]/preceding-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeImage");
    public static final Locator TXT_EMPRESA_SERVICIO_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_ServiceOrCompany']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa la empresa o servicio']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator TXT_EMPRESA_SERVICIO_POP_UP_LOCATOR = locator().withAndroid("xpath$//span[text()='{0}']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeOther/XCUIElementTypeStaticText[@name='Debe contener mínimo 3 caracteres']]/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    public static final Locator TXT_DESCRIPCION_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Description']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Ingresa la descripción de la factura']]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator TXT_FOCO_LOCATOR = locator().withAndroid("xpath$//*[text()='INSCRIBIR FACTURA MANUALMENTE']").withIos("xpath$//XCUIElementTypeStaticText[@name='INSCRIBIR FACTURA MANUALMENTE']");
    public static final Locator TXT_REFERENCIA_LOCATOR = locator().withAndroid("xpath$//input[@id='Input_Personal_Name']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[contains(@name,'Ingresa')]]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    public static final Locator LBL_INSCRIPCION_EXITOSA_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Inscripción exitosa!']").withIos("xpath$//*[@name='¡Inscripción exitosa!']");

    private InscribirFacturasLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}

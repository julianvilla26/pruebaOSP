package co.com.bancolombia.certificacion.app.userinterface.locators.eprepago;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class SolicitarTarjetaVirtualEprepagoLocator {
    public static final Locator CHK_TYC_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//input[@id='Chk_TerminosCondiciones']").withIos("xpath$//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Acepto']]/preceding-sibling::XCUIElementTypeSwitch");
    public static final Locator LBL_SOLICITUD_EPREPAGO_EXITOSA_LOCATOR = locator().withAndroid("xpath$//span[text()='¡Solicitud exitosa!']").withIos("xpath$//*[@name='¡Solicitud exitosa!']");
    public static final Locator LBL_COMPROBANTE_SOLICITUD_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'Comprobante')]").withIos("xpath$//*[contains(@name,'Comprobante')]");
    public static final Locator LBL_SALDO_DISPONIBLE_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Saldo disponible']").withIos("xpath$//*[@name='Saldo disponible']");
    public static final Locator LBL_TIPO_TARJETA_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'Tarjeta')]").withIos("xpath$//*[contains(@name,'Tarjeta')]");
    public static final Locator LBL_FECHA_VENCIMIENTO_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='Fecha de vencimiento']").withIos("xpath$//*[@name='Fecha de vencimiento']");
    public static final Locator LBL_CODIGO_CVC_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'CVC2')]").withIos("xpath$//*[contains(@name,'CVC2')]");
    public static final Locator LBL_EPREPAGO_LOCATOR = locator().withAndroid("xpath$//span[text()='e-Prepago']").withIos("xpath$//*[@name='e-Prepago']");
    public static final Locator LBL_DETALLE_PRODUCTO_LOCATOR = locator().withAndroid("xpath$//span[text()='Detalle del producto']").withIos("xpath$//*[@name='Detalle del producto']");

    public SolicitarTarjetaVirtualEprepagoLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
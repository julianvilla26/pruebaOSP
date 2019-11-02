package co.com.bancolombia.certificacion.app.userinterface.pages.eprepago;

import net.serenitybdd.screenplay.targets.Target;
import static co.com.bancolombia.certificacion.app.userinterface.locators.eprepago.SolicitarTarjetaVirtualEprepagoLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class SolicitarTarjetaVirtualEprepagoPage {
    public static final Target CHK_TYC_EPREPAGO = Target.the("check terminos y condiciones").located(theElementBy(CHK_TYC_EPREPAGO_LOCATOR));
    public static final Target LBL_SOLICITUD_EPREPAGO_EXITOSA = Target.the("solicitud eprepago exitosa").located(theElementBy(LBL_SOLICITUD_EPREPAGO_EXITOSA_LOCATOR));
    public static final Target LBL_COMPROBANTE_SOLICITUD_EPREPAGO = Target.the("Label que presenta el comprobante y número de solicitud").located(theElementBy(LBL_COMPROBANTE_SOLICITUD_EPREPAGO_LOCATOR));
    public static final Target LBL_SALDO_DISPONIBLE_EPREPAGO = Target.the("Label que muestra el saldo de la tarjeta solicitada").located(theElementBy(LBL_SALDO_DISPONIBLE_EPREPAGO_LOCATOR));
    public static final Target LBL_TIPO_TARJETA_EPREPAGO = Target.the("Tipo de tarjeta generada en la solicitud de e-Prepago").located(theElementBy(LBL_TIPO_TARJETA_EPREPAGO_LOCATOR));
    public static final Target LBL_FECHA_VENCIMIENTO_EPREPAGO = Target.the("Label que almacena la fecha de vencimiento de la e-Prepago").located(theElementBy(LBL_FECHA_VENCIMIENTO_EPREPAGO_LOCATOR));
    public static final Target LBL_CODIGO_CVC_EPREPAGO = Target.the("Label que contiene el codigo CVC de la tarjeta e-Prepago").located(theElementBy(LBL_CODIGO_CVC_EPREPAGO_LOCATOR));
    public static final Target LBL_EPREPAGO = Target.the("label eprepago").located(theElementBy(LBL_EPREPAGO_LOCATOR));
    public static final Target LBL_DETALLE_PRODUCTO = Target.the("label detalle del producto").located(theElementBy(LBL_DETALLE_PRODUCTO_LOCATOR));

    private SolicitarTarjetaVirtualEprepagoPage() {throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);}
}
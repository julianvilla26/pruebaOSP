package co.com.bancolombia.certificacion.app.userinterface.pages.eprepago;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.eprepago.DescargarTarjetaVirtualEprepagoLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class DescargarTarjetaVirtualEprepagoPage {
    public static final Target BTN_DESCARGAR_EPREPAGO = Target.the("Botón descargar ePrepago").located(theElementBy(BTN_DESCARGAR_EPREPAGO_LOCATOR));
    public static final Target LNK_DESCARGAR_EPREPAGO = Target.the("Link descargar ePrepago").located(theElementBy(LNK_DESCARGAR_EPREPAGO_LOCATOR));
    public static final Target CHK_DESCARGA_TOTAL_EPREPAGO = Target.the("Radio button para descargar el valor total de la tarjeta virtual ePrepago").located(theElementBy(CHK_DESCARGA_TOTAL_EPREPAGO_LOCATOR));
    public static final Target CHK_DESCARGA_OTRO_VALOR_EPREPAGO = Target.the("Radio button para seleccionar un monto parcial de descarga de ePrepago").located(theElementBy(CHK_DESCARGA_OTRO_VALOR_EPREPAGO_LOCATOR));
    public static final Target LBL_PRODUCTO_DESTINO_EPREPAGO = Target.the("Label que identifica las cuentas destino para la descarga de e-Prepago").located(theElementBy(LBL_PRODUCTO_DESTINO_EPREPAGO_LOCATOR));
    public static final Target LBL_DESCARGA_EXITOSA_EPREPAGO = Target.the("Label que muestra mensaje de descarga exitosa ePrepago").located(theElementBy(LBL_DESCARGA_EXITOSA_EPREPAGO_LOCATOR));
    public static final Target LBL_VALOR_DESCARGA = Target.the("Label valor de descarga").locatedBy(dynamicElement(LBL_VALOR_DESCARGA_LOCATOR));
    public static final Target TXT_VALOR_DESCARGA_EPREPAGO = Target.the("Campo de texto valor de descarga").locatedBy(dynamicElement(TXT_VALOR_DESCARGA_EPREPAGO_LOCATOR));
    public static final Target FOCO = Target.the("Foco eprepago").located(theElementBy(FOCO_LOCATOR));

    private DescargarTarjetaVirtualEprepagoPage(){throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);}
}
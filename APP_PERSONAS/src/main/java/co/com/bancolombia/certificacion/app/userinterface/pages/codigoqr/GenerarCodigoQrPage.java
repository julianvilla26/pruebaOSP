package co.com.bancolombia.certificacion.app.userinterface.pages.codigoqr;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.codigoqr.GenerarCodigoQrLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class GenerarCodigoQrPage {
    public static final Target TXT_NOMBRE_PERSONALIZADO = Target.the("Nombre personalizado").locatedBy(dynamicElement(TXT_NOMBRE_PERSONALIZADO_LOCATOR));
    public static final Target TXT_VALOR_RECIBIR = Target.the("Valor a recibir").located(theElementBy(TXT_VALOR_RECIBIR_LOCATOR));
    public static final Target BTN_CON_VALOR = Target.the("Botón con valor").located(theElementBy(BTN_CON_VALOR_LOCATOR));
    public static final Target BTN_SIN_VALOR = Target.the("Botón sin valor").located(theElementBy(BTN_SIN_VALOR_LOCATOR));
    public static final Target TXT_DESCRIPCION = Target.the("Descripción").locatedBy(dynamicElement(TXT_DESCRIPCION_LOCATOR));
    public static final Target BTN_GENERAR_QR = Target.the("Botón confirmar generación de codigo qr").located(theElementBy(BTN_GENERAR_QR_LOCATOR));
    public static final Target IMG_CODIGO_QR = Target.the("Botón confirmar generación de codigo qr").located(theElementBy(IMG_CODIGO_QR_LOCATOR));
    public static final Target IMG_CODIGO_QR_PANTALLA_INICIO = Target.the("Botón código qr de pantalla de inicio").located(theElementBy(IMG_CODIGO_QR_PANTALLA_INICIO_LOCATOR));
    public static final Target IMG_CODIGO_QR_FLOTANTE = Target.the("Botón código qr flotante de pantalla de inicio").located(theElementBy(IMG_CODIGO_QR_FLOTANTE_LOCATOR));
    public static final Target TXT_NUMERO_PRODUCTO = Target.the("Número de producto").located(theElementBy(TXT_NUMERO_PRODUCTO_LOCATOR));
    public static final Target BTN_TIPO_PRODUCTO = Target.the("Botón tipo de producto").locatedBy(dynamicElement(BTN_TIPO_PRODUCTO_LOCATOR));

    private GenerarCodigoQrPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

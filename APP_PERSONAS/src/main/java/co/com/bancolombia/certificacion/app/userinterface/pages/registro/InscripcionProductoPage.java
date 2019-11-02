package co.com.bancolombia.certificacion.app.userinterface.pages.registro;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.GeneralLocator.BTN_SIGUIENTE_LOCATOR;
import static co.com.bancolombia.certificacion.app.userinterface.locators.GeneralLocator.LNK_SIGUIENTE_LOCATOR;
import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.InscripcionProductoLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class InscripcionProductoPage {
    public static final Target TXT_BANCO = Target.the("Campo para ingresar banco").located(theElementBy(TXT_BANCO_LOCATOR));
    public static final Target TXT_NUMERO_PRODUCTO = Target.the("Campo para ingresar numero de producto a inscribir").located(theElementBy(TXT_NUMERO_PRODUCTO_LOCATOR));
    public static final Target ITEM_NOMBRE_BANCO = Target.the("Selecciona el nombre del banco").locatedBy(dynamicElement(ITEM_NOMBRE_BANCO_LOCATOR));
    public static final Target TXT_BUSCAR_NOMBRE_BANCO = Target.the("Campo para ingresar nombre banco").located(theElementBy(TXT_BUSCAR_NOMBRE_BANCO_LOCATOR));
    public static final Target BTN_SIGUIENTE = Target.the("Boton siguiente").located(theElementBy(BTN_SIGUIENTE_LOCATOR));
    public static final Target BTN_CERRAR_SELECCION_BANCO = Target.the("Boton CERRAR seleccion banco").located(theElementBy(BTN_CERRAR_SELECCION_BANCO_LOCATOR));
    public static final Target CHK_TIPO_CUENTA = Target.the("Selecciona el tipo de cuenta que desea inscribir").locatedBy(dynamicElement(CHK_TIPO_CUENTA_LOCATOR));
    public static final Target TXT_TIPO_DOCUMENTO = Target.the("Campo para ingresar tipo de documento").located(theElementBy(TXT_TIPO_DOCUMENTO_LOCATOR));
    public static final Target ITEM_TIPO_DOCUMENTO = Target.the("Selecciona item del tipo de documento en la lista").locatedBy(dynamicElement(ITEM_TIPO_DOCUMENTO_LOCATOR));
    public static final Target TXT_NUMERO_DOCUMENTO = Target.the("Campo ingresa numero de documento").located(theElementBy(TXT_NUMERO_DOCUEMENTO_LOCATOR));
    public static final Target BTN_INSCRIBIR = Target.the("Clic en el boton inscribir").located(theElementBy(BTN_INSCRIBIR_LOCATOR));
    public static final Target IMG_CONFIRMACION = Target.the("Imagen confirmacion").located(theElementBy(IMG_CONFIRMACION_LOCATOR));
    public static final Target LBL_TIPO_PRODUCTO = Target.the("Label del tipo de producto presente en la pantalla de confirmacion").locatedBy(dynamicElement(LBL_TIPO_PRODUCTO_LOCATOR));
    public static final Target LBL_BANCO = Target.the("Label tipo de banco inscrito en la pantalla de confirmacion").locatedBy(dynamicElement(LBL_BANCO_LOCATOR));
    public static final Target LBL_NUMERO_PRODUCTO = Target.the("Label tipo de numero en la pantalla de confirmacion").locatedBy(dynamicElement(LBL_NUMERO_PRODUCTO_LOCATOR));
    public static final Target LBL_TIPO_DOCUMENTO = Target.the("Label tipo de documento en la pantalla de confirmacion").locatedBy(dynamicElement(LBL_TIPO_DOCUMENTO_LOCATOR));
    public static final Target LBL_NUMERO_DOCUMENTO = Target.the("Label numero de docuemento en la pantalla de confirmacion").locatedBy(dynamicElement(LBL_NUMERO_DOCUMENTO_LOCATOR));
    public static final Target LBL_CUENTA_PENDIENTE_CONFIRMACION = Target.the("Label cuenta pendiente de activacon").locatedBy(dynamicElement(LBL_CUENATA_PENDIENTE_CONFIRMACION_LOCATOR));
    public static final Target FOCO = Target.the("Foco").located(theElementBy(FOCO_LOCATOR));

    private InscripcionProductoPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}
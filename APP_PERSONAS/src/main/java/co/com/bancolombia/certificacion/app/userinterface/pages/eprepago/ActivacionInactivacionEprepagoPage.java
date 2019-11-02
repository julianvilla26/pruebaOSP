package co.com.bancolombia.certificacion.app.userinterface.pages.eprepago;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.eprepago.ActivacionInactivacionEprepagoLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class ActivacionInactivacionEprepagoPage {

    public static final Target TXT_EPREPAGO = Target.the("opciones eprepago").locatedBy(dynamicElement(TXT_EPREPAGO_LOCATOR));
    public static final Target BTN_GENERAR_EPREPAGO = Target.the("boton generar eprepago").located(theElementBy(BTN_GENERAR_EPREPAGO_LOCATOR));
    public static final Target LBL_GENERARACION_EXITOSA = Target.the("label generacion exitosa eprepago").located(theElementBy(LBL_GENERARACION_EXITOSA_LOCATOR));
    public static final Target TXT_CAMPOS_ACTIVACION_EPREPAGO = Target.the("campos activacion eprepago").locatedBy(dynamicElement(TXT_CAMPOS_ACTIVACION_EPREPAGO_LOCATOR));
    public static final Target BTN_CANCELAR_ACCION_EPREPAGO = Target.the("boton cancelar activacion eprepago").located(theElementBy(BTN_CANCELAR_ACTIVACION_EPREPAGO_LOCATOR));
    public static final Target BTN_ACTIVAR_EPREPAGO = Target.the("Boton activar e-prepago").located(theElementBy(BTN_ACTIVAR_EPREPAGO_LOCATOR));
    public static final Target BTN_INACTIVAR_NUMERO = Target.the("Boton inactivar numero").located(theElementBy(BTN_INACTIVAR_NUMERO_LOCATOR));
    public static final Target BTN_INACTIVAR_EPREPAGO = Target.the("Boton inactivar e-prepago").located(theElementBy(BTN_INACTIVAR_EPREPAGO_LOCATOR));
    public static final Target LBL_INACTIVACION_EXITOSA = Target.the("Label inactivación exitosa e-prepago").located(theElementBy(LBL_INACTIVACION_EXITOSA_LOCATOR));
    public static final Target LBL_NUMERO_MAXIMO_INACTIVACIONES = Target.the("Label número máximo de inactivaciones de tarjeta e-prepago").located(theElementBy(LBL_NUMERO_MAXIMO_INACTIVACIONES_LOCATOR));

    private ActivacionInactivacionEprepagoPage() {throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);}
}

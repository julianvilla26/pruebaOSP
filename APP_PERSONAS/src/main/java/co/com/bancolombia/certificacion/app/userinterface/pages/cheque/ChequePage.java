package co.com.bancolombia.certificacion.app.userinterface.pages.cheque;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.cheque.chequeLocator.*;
import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.InscripcionClaveDinamicaLocator.CHK_TIPO_CORREO_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class ChequePage {
    public static final Target CHK_CHEQUE = Target.the("Selecciona el tipo cheque").locatedBy(dynamicElement(CHK_TIPO_CORREO_LOCATOR));
    public static final Target TXT_NUMERO_CHEQUE = Target.the("Campo de texto para ingresar numero de cheque").located(theElementBy(TXT_NUMERO_CHEQUE_LOCATOR));
    public static final Target BTN_CONTRAORDENAR = Target.the("Boton contraordenar cheque").located(theElementBy(BTN_CONTRAORDENAR_LOCATOR));
    public static final Target OPT_CUENTA_ASOCIADA = Target.the("Opcion para selecciona cuenta asociada a cheque ").locatedBy(dynamicElement(OPT_CUENTA_ASOCIADA_LOCATOR));
    public static final Target LBL_CONTRAORDEN_EXITOSA = Target.the("Label verificar contraorden exitoso").located(theElementBy(LBL_CONTRAORDEN_EXITOSA_LOCATOR));
    public static final Target LBL_COMPROBANTE = Target.the("Label para verificar comprandote").located(theElementBy(LBL_COMPROBANTE_LOCATOR));
    public static final Target LBL_NUMERO_CHEQUE_RANGO = Target.the("Label para verificar numero de cheque con rango").locatedBy(dynamicElement(LBL_NUMERO_CHEQUE_RANGO_LOCATOR));
    public static final Target LBL_NUMERO_CHEQUE = Target.the("Label para verificar numero de cheque").locatedBy(dynamicElement(LBL_NUMERO_CHEQUE_LOCATOR));
    public static final Target LBL_CUENTA_ASOCIADA = Target.the("Label para verificar cuenta asociada").locatedBy(dynamicElement(LBL_CUENTA_ASOCIADA_LOCATOR));
    public static final Target TXT_DESDE = Target.the("Campo de texto cheque a contraordenar rango desde").located(theElementBy(TXT_DESDE_LOCATOR));
    public static final Target TXT_HASTA = Target.the("Campo de texto cheque a contraordenar rango hasta").located(theElementBy(TXT_HASTA_LOCATOR));
    public static final Target LBL_FOCO = Target.the("Foco para habilitar link siguiente en cheques").located(theElementBy(LBL_FOCO_LOCATOR));
}
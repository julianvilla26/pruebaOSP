package co.com.bancolombia.certificacion.app.userinterface.pages.registro;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.RegistroLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class RegistroPage {
    public static final Target TXT_CREAR_USUARIO = Target.the("Campo crear usuario").located(theElementBy(TXT_CREAR_USUARIO_LOCATOR));
    public static final Target TXT_CORREO = Target.the("campo correo").located(theElementBy(TXT_CORREO_LOCATOR));
    public static final Target LBL_CORREO = Target.the("label correo").located(theElementBy(LBL_CORREO_LOCATOR));
    public static final Target LBL_TIPO_CORREO = Target.the("label correo").located(theElementBy(LBL_TIPO_CORREO_LOCATOR));
    public static final Target CHECK_TIPO_CORREO = Target.the("check tipo correo").located(theElementBy(CHECK_TIPO_CORREO_LOCATOR));
    public static final Target CHECK_TYC = Target.the("check terminos y condiciones").located(theElementBy(CHECK_TYC_LOCATOR));
    public static final Target BTN_REGISTRO = Target.the("boton registro").located(theElementBy(BTN_REGISTRO_LOCATOR));
    public static final Target LBL_VALIDACION_REGISTRO_OK = Target.the("label registro OK").located(theElementBy(LBL_VALIDACION_REGISTRO_OK_LOCATOR));
    public static final Target LBL_INICIA_REGISTRO = Target.the("label inicia el registro").located(theElementBy(LBL_INICIA_REGISTRO_LOCATOR));

    private RegistroPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}
package co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.autenticacion.InicioSesionLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class InicioSesionPage {
    public static final Target BTN_INGRESAR = Target.the("Boton ingresar Login").located(theElementBy(BTN_INGRESAR_LOCATOR));
    public static final Target TXT_USUARIO = Target.the("Campo ingresar usuario").located(theElementBy(TXT_USUARIO_LOCATOR));
    public static final Target LBL_HOLA_PROVISIONAL = Target.the("Label Hola para Continuar").located(theElementBy(LBL_HOLA_PROVIVIONAL_LOCATOR));
    public static final Target BTN_CONTINUAR = Target.the("Boton Continuar").located(theElementBy(BTN_CONTINUAR_LOCATOR));
    public static final Target TXT_CLAVE_DIGITOS = Target.the("Digito para clave").located(theElementBy(TXT_CLAVE_DIGITOS_LOCATOR));
    public static final Target TAB = Target.the("Tab para ingreso de clave").located(theElementBy(TAB_LOCATOR));
    public static final Target TXT_SEGUNDA_CLAVE_DIGITOS = Target.the("Digito para Segunda clave").located(theElementBy(TXT_SEGUNDA_CLAVE_DIGITOS_LOCATOR));
    public static final Target LBL_CLAVE_INVALIDA = Target.the("clave invalida").located(theElementBy(LBL_CLAVE_INVALIDA_LOCATOR));
    public static final Target LBL_USER_YA_REGISTRADO = Target.the("mensaje usuario ya registrado").located(theElementBy(LBL_USER_YA_REGISTRADO_LOCATOR));
    public static final Target BTN_CERRAR_MODAL_CLAVE_NO_VALIDA = Target.the("Boton cerrar clave invalida").located(theElementBy(BTN_CERRAR_MODAL_CLAVE_NO_VALIDA_LOCATOR));
    public static final Target LBL_CLAVE_BLOQUEADA = Target.the("clave bloqueada").located(theElementBy(LBL_CLAVE_BLOQUEADA_LOCATOR));
    public static final Target BTN_CERRAR_SESION = Target.the("Boton cerrar sesion").located(theElementBy(BTN_CERRAR_SESION_LOCATOR));
    public static final Target BTN_SI_CERRAR_SESION = Target.the("Boton SI cerrar sesion").located(theElementBy(BTN_SI_CERRAR_SESION_LOCATOR));
    public static final Target BTN_VOLVER = Target.the("Boton Volver").located(theElementBy(BTN_VOLVER_LOCATOR));
    public static final Target BTN_FOCO_CERRAR_SESION = Target.the("foco cerrar sesion").located(theElementBy(BTN_FOCO_CERRAR_SESION_LOCATOR));

    private InicioSesionPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}
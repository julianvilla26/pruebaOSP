package co.com.bancolombia.certificacion.app.userinterface.pages.registro;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.consultas.saldos.SaldosMovimientosLocator.OPT_CUENTA_PRODUCTO_LOCATOR;
import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.InscripcionClaveDinamicaLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class InscripcionClaveDinamicaPage {
    public static final Target TXT_NOMBRE_PERSONALIZADO = Target.the("Campo de texto para ingresar nombre personalizado").located(theElementBy(TXT_NOMBRE_PERSONALIZADO_LOCATOR));
    public static final Target TXT_CORREO = Target.the("Campo de texto para ingresar correo").located(theElementBy(TXT_CORREO_CLAVE_LOCATOR));
    public static final Target CHK_TIPO_CORREO = Target.the("Selecciona el tipo de correo").locatedBy(dynamicElement(CHK_TIPO_CORREO_LOCATOR));
    public static final Target TXT_NUMERO_CELULAR = Target.the("Campo de texto para ingresar numero de celular").located(theElementBy(TXT_NUMERO_CELULAR_LOCATOR));
    public static final Target CHK_ACEPTO_TERMINOS = Target.the("Check acepto terminos y condiciones").located(theElementBy(CHK_ACEPTO_TERMINOS_LOCATOR));
    public static final Target CHK_FOCO_ACEPTO = Target.the("Check acepto terminos y condiciones").located(theElementBy(CHK_FOCO_ACEPTO_LOCATOR));
    public static final Target TXT_FOCO_NOMBRE_PERSONALIZADO = Target.the("Foco en pantalla de nombre personalizado").located(theElementBy(TXT_FOCO_NOMBRE_PERSONALIZADO_LOCATOR));
    public static final Target BTN_INSCRIBIR_CLAVE = Target.the("Boton inscribir clave").located(theElementBy(BTN_INSCRIBIR_CLAVE_LOCATOR));
    public static final Target BTN_INSCRIBIR_DINAMICA_CLAVE = Target.the("Boton principal para inscribir clave").located(theElementBy(BTN_INSCRIBIR_CLAVE_DINAMICA_LOCATOR));
    public static final Target TXT_SEGUNDA_CLAVE = Target.the("Campo de texto segunda clave").located(theElementBy(TXT_SEGUNDA_CLAVE_LOCATOR));
    public static final Target BTN_CONTINUAR_SEGUNDA_CLAVE = Target.the("Boton continuar segunda clave").located(theElementBy(BTN_CONTINUAR_SEGUNDA_CLAVE_LOCATOR));
    public static final Target LBL_VERIFICACION_CLAVE_DINAMICA = Target.the("Datos para verificacion registro clave dinamica").locatedBy(dynamicElement(OPT_CUENTA_PRODUCTO_LOCATOR));
    public static final Target LNL_COMPROBANTE_CLAVE_DINAMICA = Target.the("Comprobante de inscripcion clave dinamica").located(theElementBy(LBL_COMPROBANTE_CLAVE_DINAMICA_LOCATOR));
    public static final Target LNK_ELIMINAR_CLAVE_DINAMICA = Target.the("Link eliminar clave dinamica").locatedBy(dynamicElement(LNK_ELIMINAR_CLAVE_DINAMICA_LOCATOR));
    public static final Target BTN_ELIMINAR_CLAVE_DINAMICA = Target.the("Botón eliminar clave dinamica").located(theElementBy(BTN_ELIMINAR_CLAVE_DINAMICA_LOCATOR));
    public static final Target LBL_VERIFICACION_ELIMINAR_CLAVE_DINAMICA = Target.the("label verificar elimincacion clave dinamica").locatedBy(dynamicElement(LBL_VERIFICACION_ELIMINAR_CLAVE_DINAMICA_LOCATOR));
    public static final Target LBL_VERIFICACION_MENSAJE_CLAVE_DINAMICA = Target.the("Label mensaje eliminacion clave dinamica").located(theElementBy(LBL_VERIFICACION_MENSAJE_CLAVE_DINAMICA_LOCATOR));
    public static final Target FOCO_INSCRIPCION = Target.the("Foco inscripción").located(theElementBy(FOCO_INSCRIPCION_LOCATOR));

    private InscripcionClaveDinamicaPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}
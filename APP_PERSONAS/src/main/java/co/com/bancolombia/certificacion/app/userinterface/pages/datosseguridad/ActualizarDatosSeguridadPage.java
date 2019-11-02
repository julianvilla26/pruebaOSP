package co.com.bancolombia.certificacion.app.userinterface.pages.datosseguridad;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.consultas.saldos.SaldosMovimientosLocator.OPT_CUENTA_PRODUCTO_LOCATOR;
import static co.com.bancolombia.certificacion.app.userinterface.locators.datosseguridad.ActualizarDatosSeguridadLocator.*;
import static co.com.bancolombia.certificacion.app.userinterface.locators.registro.InscripcionClaveDinamicaLocator.LBL_ACTUALIZACION_EXITOSA_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.dynamicElement;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class ActualizarDatosSeguridadPage {
    public static final Target LBL_ACTULIZACION_EXITOSA = Target.the("Label mensaje actualización exitosa").located(theElementBy(LBL_ACTUALIZACION_EXITOSA_LOCATOR));
    public static final Target LBL_VERIFICACION_ACTUALIZACION_DATOS = Target.the("Datos para verificacion registro clave dinamica").locatedBy(dynamicElement(OPT_CUENTA_PRODUCTO_LOCATOR));
    public static final Target TXT_CORREO_ACTUALIZAR = Target.the("Campo de texto para actualizar correo").located(theElementBy(TXT_CORREO_ACTUALIZAR_LOCATOR));
    public static final Target TXT_NUMERO_ACTUALIZAR = Target.the("Campo de texto para actualizar numero de celular").located(theElementBy(TXT_NUMERO_ACTUALIZAR_LOCATOR));
    public static final Target FOCO = Target.the("foco").located(theElementBy(FOCO_LOCATOR));
}
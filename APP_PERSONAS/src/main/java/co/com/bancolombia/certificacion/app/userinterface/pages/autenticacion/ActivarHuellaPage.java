package co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.autenticacion.ActivarHuellaLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class ActivarHuellaPage {
    public static final Target IMG_ACTIVAR_HUELLA = Target.the("Imagen principal activar huella").located(theElementBy(IMG_ACTIVAR_HUELLA_LOCATOR));
    public static final Target BTN_CANCELAR_HUELLA = Target.the("Boton cancelar registro huella").located(theElementBy(BTN_CANCELAR_HUELLA_LOCATOR));
    public static final Target BTN_SALTAR_HUELLA = Target.the("Boton saltar registro huella").located(theElementBy(BTN_SALTAR_HUELLA_LOCATOR));

    private ActivarHuellaPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

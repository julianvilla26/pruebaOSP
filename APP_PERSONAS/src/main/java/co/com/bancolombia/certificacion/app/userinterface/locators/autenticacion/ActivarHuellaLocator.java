package co.com.bancolombia.certificacion.app.userinterface.locators.autenticacion;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class ActivarHuellaLocator {
    public static final Locator IMG_ACTIVAR_HUELLA_LOCATOR = locator().withAndroid("xpath$//android.widget.Image[@resource-id='huellaimage']").withIos("");
    public static final Locator BTN_CANCELAR_HUELLA_LOCATOR = locator().withAndroid("xpath$//android.view.View[@resource-id='Link_Skip_ActivateBiometricsStep2']").withIos("");
    public static final Locator BTN_SALTAR_HUELLA_LOCATOR = locator().withAndroid("xpath$//android.view.View[@resource-id='Link_Skip_ActivateBiometricsStep1']").withIos("");

    private ActivarHuellaLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}

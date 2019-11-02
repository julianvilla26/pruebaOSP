package co.com.bancolombia.certificacion.app.userinterface.locators.billetera;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_LOCATOR;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.Locator.locator;

public class BilleteraLocator {
    public static final Locator BTN_CONTINUAR_BILLETERA_LOCATOR = locator().withAndroid("xpath$//button[text()='CONTINUAR']").withIos("xpath$d");
    public static final Locator BTN_SIGUIENTE_ON_BOARDING_LOCATOR = locator().withAndroid("xpath$//button[text()='SIGUIENTE']").withIos("xpath$d");
    public static final Locator CHK_TERMINOS_CONDICIONES_BILLETERA_LOCATOR = locator().withAndroid("xpath$//input[@id='Chk_TerminosCondiciones']").withIos("xpath$d");
    public static final Locator BTN_COMENZAR_REGISTRO_BILLETERA_LOCATOR = locator().withAndroid("xpath$//button//span[text()='COMENZAR']").withIos("xpath$d");
    public static final Locator LBL_TARJETAS_LISTADAS_LOCATOR = locator().withAndroid("xpath$//div[@class='content']").withIos("xpath$d");
    public static final Locator BTN_ACTIVAR_TARJETA_LOCATOR = locator().withAndroid("xpath$//button[text()='ACTIVAR']").withIos("xpath$d");
    public static final Locator LBL_ACTIVACION_EXITOSA_LOCATOR = locator().withAndroid("xpath$//span[contains(text(),'¡Activación exitosa!')]").withIos("xpath$d");

    private BilleteraLocator() {
        throw new IllegalStateException(CLASE_LOCATOR);
    }
}
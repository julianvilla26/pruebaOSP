package co.com.bancolombia.certificacion.app.userinterface.pages.billetera;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.bancolombia.certificacion.app.userinterface.locators.billetera.BilleteraLocator.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_INTERFAZ_USUARIO;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.theElementBy;

public class BilleteraPage {
    public static final Target BTN_CONTINUAR_BILLETERA = Target.the("Boton de continuar billatera").located(theElementBy(BTN_CONTINUAR_BILLETERA_LOCATOR));
    public static final Target BTN_SIGUIENTE_ON_BOARDING = Target.the("Boton siguiente on boparding billetera").located(theElementBy(BTN_SIGUIENTE_ON_BOARDING_LOCATOR));
    public static final Target CHK_TERMINOS_CONDICIONES_BILLETERA = Target.the("Check Terminos Condiciones billetera").located(theElementBy(CHK_TERMINOS_CONDICIONES_BILLETERA_LOCATOR));
    public static final Target BTN_COMENZAR_REGISTRO_BILLETERA = Target.the("Boton Comenzar registro billetera").located(theElementBy(BTN_COMENZAR_REGISTRO_BILLETERA_LOCATOR));
    public static final Target LBL_TARJETAS_LISTADAS = Target.the("Titulo de tarjetas listadas").located(theElementBy(LBL_TARJETAS_LISTADAS_LOCATOR));
    public static final Target BTN_ACTIVAR_BILLETERA = Target.the("Boton activar Billetera").located(theElementBy(BTN_ACTIVAR_TARJETA_LOCATOR));
    public static final Target LBL_ACTIVACION_EXITOSA = Target.the("Titulo Activacion exitosa").located(theElementBy(LBL_ACTIVACION_EXITOSA_LOCATOR));

    private BilleteraPage() {
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}

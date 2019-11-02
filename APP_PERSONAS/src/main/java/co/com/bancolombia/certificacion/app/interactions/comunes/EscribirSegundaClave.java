package co.com.bancolombia.certificacion.app.interactions.comunes;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.type.Type;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.TXT_SEGUNDA_CLAVE;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class EscribirSegundaClave implements Interaction {
    private String cadena;

    public EscribirSegundaClave(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String platform= ElementFinder.getPlatformCapability();

        if(("Android").equalsIgnoreCase(platform)){
            TXT_SEGUNDA_CLAVE.resolveFor(actor).click();
            AndroidDriver driver = getProxiedDriver();
            for (int i = 0; i < cadena.length(); i++) {
                char letra = cadena.charAt(i);
                boolean mayus = Character.isUpperCase(letra);
                String letraTeclado = String.valueOf(letra);
                char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                        'w', 'x', 'y', 'z', '@', '.', '1', ' ', '2', '3', '4', '5',
                        '6', '7', '8', '9', '0'};
                int[] codigoLetra = {29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
                        42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 77, 56,
                        8, 62, 9, 10, 11, 12, 13, 14, 15, 16, 7};
                for (int j = 0; j <= 38; j++) {
                    String letraA = String.valueOf(letras[j]);
                    if (letraTeclado.equalsIgnoreCase(letraA) && mayus) {
                        driver.pressKeyCode(codigoLetra[j],
                                AndroidKeyMetastate.META_CAPS_LOCK_ON);
                    } else if (letraTeclado.equalsIgnoreCase(letraA) && !mayus) {
                        driver.pressKeyCode(codigoLetra[j]);
                    }
                }
            }
        }
        else {
            AppiumDriver driver = getProxiedDriver();
            (new TouchAction(driver)).tap(PointOption.point(122, 350)).perform();
            actor.attemptsTo(
                    Type.theValue(cadena).into(TXT_SEGUNDA_CLAVE)
            );
        }
    }

    public static EscribirSegundaClave enLaApp(String cadena){
        return new EscribirSegundaClave(cadena);
    }
}
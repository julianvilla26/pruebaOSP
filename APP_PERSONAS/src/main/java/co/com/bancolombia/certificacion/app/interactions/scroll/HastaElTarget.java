package co.com.bancolombia.certificacion.app.interactions.scroll;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class HastaElTarget implements Interaction {
    private Target elemento;

    public HastaElTarget(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String platform = ElementFinder.getPlatformCapability();
        if (("Android").equalsIgnoreCase(platform)) {
            actor.attemptsTo(
                    Check.whether(!Verificar.elementoVisible(actor, elemento)).andIfSo(
                            Scroll.to(elemento)
                    )
            );
        } else {
            AppiumDriver driver = getProxiedDriver();
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension dimension = driver.manage().window().getSize();
            int posicionInicialX = dimension.width / 2;
            int posicionInicialY = dimension.height / 2;
            while (!Verificar.elementoVisible(actor, elemento)) {
                action.longPress(PointOption.point(posicionInicialX, 400));
                action.moveTo(PointOption.point(posicionInicialX, posicionInicialY));
                action.release().perform();
            }
        }
    }
}
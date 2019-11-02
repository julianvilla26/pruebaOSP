package co.com.bancolombia.certificacion.app.interactions.scroll;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class ScrollVisible implements Interaction {
    private Target elemento;

    public ScrollVisible(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getProxiedDriver();
        Dimension dimension = driver.manage().window().getSize();

        int posicionFijaX = dimension.width / 2;
        int posicionInicialY = dimension.height / 2;
        int posicionFinalY = dimension.height / 4;

        TouchAction action = new TouchAction((AppiumDriver) driver);
        while (!elemento.resolveFor(actor).isVisible()) {
            action.longPress(PointOption.point(posicionFijaX, posicionInicialY));
            action.moveTo(PointOption.point(posicionFijaX, posicionFinalY));
            action.release().perform();
        }
    }

}
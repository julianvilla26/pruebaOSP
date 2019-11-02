package co.com.bancolombia.certificacion.app.interactions.comunes;

import co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.TAB;
import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.TXT_CLAVE_DIGITOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Escribir implements Interaction {
    private String cadena;

    public Escribir(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String platform = ElementFinder.getPlatformCapability();
        actor.attemptsTo(
                Check.whether(("iOS").equalsIgnoreCase(platform)).andIfSo(
                        Click.on(TAB)
                ),
                Type.theValue(cadena).into(TXT_CLAVE_DIGITOS)
        );
    }

    public static Escribir enCampoTexto(String cadena) {
        return instrumented(Escribir.class, cadena);
    }
}
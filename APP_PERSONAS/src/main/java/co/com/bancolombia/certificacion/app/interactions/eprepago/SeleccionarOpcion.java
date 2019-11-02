package co.com.bancolombia.certificacion.app.interactions.eprepago;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.BTN_SELECCIONAR_OPCION;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.BTN_SUB_MENU_EPREPAGO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SeleccionarOpcion implements Task {
    private String opcion;

    public SeleccionarOpcion(String opcion){this.opcion = opcion;}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SUB_MENU_EPREPAGO, isPresent()),
                RealizarScroll.hastaPosicionDeTarget(BTN_SUB_MENU_EPREPAGO),
                Click.on(BTN_SUB_MENU_EPREPAGO),
                Click.on(BTN_SELECCIONAR_OPCION.of(opcion))
        );
    }

    public static SeleccionarOpcion deSubmenu(String opcion){
        return Tasks.instrumented(SeleccionarOpcion.class, opcion);
    }
}
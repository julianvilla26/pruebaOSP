package co.com.bancolombia.certificacion.app.tasks.bloqueos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Tarjeta implements Task {
    private Producto producto;

    public Tarjeta(Producto producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, LBL_TARJETAS)).andIfSo(
                        RealizarScroll.hastaPosicionDeTarget(BTN_TARJETA_BLOQUEAR.of(producto.getTipo(), producto.getNumero())),
                        Click.on(BTN_TARJETA_BLOQUEAR.of(producto.getTipo(), producto.getNumero()))
                        ),
                Click.on(LNK_BLOQUEAR),
                WaitUntil.the(BTN_BLOQUEAR, isEnabled()),
                Click.on(BTN_BLOQUEAR),
                Validar.carga()
        );
        actor.remember(MODELO_PRODUCTO, producto);
    }
}

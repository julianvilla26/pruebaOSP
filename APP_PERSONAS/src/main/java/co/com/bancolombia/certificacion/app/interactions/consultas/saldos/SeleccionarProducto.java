package co.com.bancolombia.certificacion.app.interactions.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SeleccionarProducto implements Interaction {
    private String tipoCuenta;
    private String numeroCuenta;
    private Target target;

    public SeleccionarProducto(String tipoCuenta, String numeroCuenta, Target target) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target.of(tipoCuenta, numeroCuenta), isPresent()),
                RealizarScroll.hastaPosicionDeTarget(target.of(tipoCuenta, numeroCuenta)),
                Click.on(target.of(tipoCuenta, numeroCuenta))
        );
    }

    public static SeleccionarProducto desdeSaldosMovimientos(String tipoCuenta, String numeroCuenta, Target target) {
        return instrumented(SeleccionarProducto.class, tipoCuenta, numeroCuenta, target);
    }
}
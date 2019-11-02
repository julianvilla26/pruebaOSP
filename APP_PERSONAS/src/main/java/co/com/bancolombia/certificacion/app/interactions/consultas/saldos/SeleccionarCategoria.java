package co.com.bancolombia.certificacion.app.interactions.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.CUENTAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCategoria implements Interaction {
    private String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static SeleccionarCategoria deSaldosMovimientos(String categoria) {
        return instrumented(SeleccionarCategoria.class, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!CUENTAS.equals(categoria)) {
            actor.attemptsTo(
                    Esperar.unTiempo(3000),
                    Check.whether(elementoVisible(actor, OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS.of(CUENTAS))).andIfSo(
                            Click.on(OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS.of(CUENTAS))
                    ),
                    RealizarScroll.hastaPosicionDeTarget(OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS.of(categoria)),
                    Click.on(OPCION_SELECCIONAR_CATEGORIA_PRODUCTOS.of(categoria)),
                    Esperar.unTiempo(3000)
            );
        }
    }
}
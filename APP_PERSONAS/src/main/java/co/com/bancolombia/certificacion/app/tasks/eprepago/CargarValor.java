package co.com.bancolombia.certificacion.app.tasks.eprepago;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_PRODUCTO_ORIGEN;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CargarValor implements Task {
    private Producto producto;
    private String valorRecarga;

    public CargarValor(Producto producto, String valorRecarga){
        this.producto = producto;
        this.valorRecarga = valorRecarga;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RealizarScroll.hastaPosicionDeTarget(BTN_RECARGAR_EPREPAGO),
                Click.on(BTN_RECARGAR_EPREPAGO),
                Check.whether(Verificar.elementoVisible(actor, LBL_PRODUCTO_ORIGEN_EPREPAGO))
                        .andIfSo(
                                RealizarScroll.hastaPosicionDeTarget(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero())),
                                Click.on(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero()))
                        ),
                Enter.theValue(valorRecarga).into(TXT_VALOR_RECARGA_EPREPAGO),
                Click.on(FOCO_E_PREPAGO),
                WaitUntil.the(LNK_SIGUIENTE, isEnabled()),
                Click.on(LNK_SIGUIENTE)
        );
    }

    public static CargarValor sobreElValorMaximoCon(ProductoBuilder producto, String valorRecarga){
        return instrumented(CargarValor.class, producto.build(), valorRecarga);
    }
}
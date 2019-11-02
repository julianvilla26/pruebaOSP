package co.com.bancolombia.certificacion.app.tasks.eprepago;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
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
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.RECARGAR_EPREPAGO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CargarEprepago implements Task {
    private Producto producto;
    private String valorCarga;

    public CargarEprepago(Producto producto, String valorCarga) {
        this.producto = producto;
        this.valorCarga = valorCarga;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Validar.carga(),
                RealizarScroll.hastaPosicionDeTarget(BTN_RECARGAR_EPREPAGO),
                Click.on(BTN_RECARGAR_EPREPAGO));
        actor.attemptsTo(
                Check.whether(Verificar.elementoVisible(actor, LBL_PRODUCTO_ORIGEN_EPREPAGO)).andIfSo(
                        RealizarScroll.hastaPosicionDeTarget(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero())),
                        Click.on(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero()))
                ));
        actor.attemptsTo(
                Enter.theValue(valorCarga).into(TXT_VALOR_RECARGA_EPREPAGO),
                Click.on(FOCO_E_PREPAGO),
                WaitUntil.the(LNK_SIGUIENTE, isEnabled()),
                Click.on(LNK_SIGUIENTE),
                Validar.carga(),
                Click.on(LNK_RECARGAR_EPREPAGO),
                Validar.carga());
        actor.remember(MODELO_PRODUCTO, producto);
        actor.remember(RECARGAR_EPREPAGO, valorCarga);
    }

    public static CargarEprepago con(ProductoBuilder producto, String valorCarga){
        return instrumented(CargarEprepago.class, producto.build(), valorCarga);
    }
}
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
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.DescargarTarjetaVirtualEprepagoPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.TOTAL;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.DESCARGAR_EPREPAGO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class DescargarSaldo implements Task {
    private Producto producto;
    private String valorDescarga;

    public DescargarSaldo(Producto producto, String valorDescarga) {
        this.producto = producto;
        this.valorDescarga = valorDescarga;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Validar.carga(),
                Click.on(BTN_DESCARGAR_EPREPAGO),
                Validar.carga());
        actor.attemptsTo(
                Check.whether(Verificar.elementoVisible(actor, LBL_PRODUCTO_DESTINO_EPREPAGO))
                .andIfSo(
                        RealizarScroll.hastaTargetVisible(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero())),
                        Click.on(BTN_PRODUCTO_ORIGEN.of(producto.getTipo(), producto.getNumero()))
                ));
        actor.attemptsTo(
                Validar.carga(),
                Check.whether(TOTAL.equalsIgnoreCase(valorDescarga))
                        .andIfSo(
                                Click.on(CHK_DESCARGA_TOTAL_EPREPAGO))
                        .otherwise(
                                Click.on(CHK_DESCARGA_OTRO_VALOR_EPREPAGO),
                                WaitUntil.the(TXT_VALOR_DESCARGA_EPREPAGO, isEnabled()),
                                Enter.theValue(valorDescarga).into(TXT_VALOR_DESCARGA_EPREPAGO),
                                Click.on(FOCO)
                        ));
        actor.attemptsTo(
                WaitUntil.the(LNK_SIGUIENTE, isEnabled()),
                Click.on(LNK_SIGUIENTE),
                Validar.carga(),
                Click.on(LNK_DESCARGAR_EPREPAGO),
                Validar.carga());

        actor.remember(MODELO_PRODUCTO, producto);
        actor.remember(DESCARGAR_EPREPAGO, valorDescarga);
    }

    public static DescargarSaldo deLaTarjetaCon(ProductoBuilder producto, String valorDescarga) {
        return instrumented(DescargarSaldo.class, producto.build(), valorDescarga);
    }
}
package co.com.bancolombia.certificacion.app.tasks.crediagil;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_VERIFICACION;
import static co.com.bancolombia.certificacion.app.userinterface.pages.crediagil.CrediagilPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.pagos.PagosPage.OPT_PRODUCTO_ORIGEN;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.CUENTAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DesembolsarCreadiagil implements Task {
    private String valorDesembolsar;
    private Producto productoDesembolso;

    public DesembolsarCreadiagil(String valorDesembolsar, Producto productoDesembolso) {
        this.valorDesembolsar = valorDesembolsar;
        this.productoDesembolso = productoDesembolso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Verificar.elementoVisible(actor, LBL_VERIFICACION.of(CUENTAS))) {
            actor.attemptsTo(
                    RealizarScroll.hastaPosicionDeTarget(OPT_PRODUCTO_ORIGEN.of(productoDesembolso.getTipo(), productoDesembolso.getNumero())),
                    Click.on(OPT_PRODUCTO_ORIGEN.of(productoDesembolso.getTipo(), productoDesembolso.getNumero()))
            );
        }
        actor.attemptsTo(
                Enter.theValue(valorDesembolsar).into(TXT_VALOR_DESEMBOLSAR),
                Click.on(FOCO)
        );
    }

    public static DesembolsarCreadiagil fueraRango(String valorDesembolsar, ProductoBuilder productoDesembolso) {
        return instrumented(DesembolsarCreadiagil.class, valorDesembolsar, productoDesembolso.build());
    }
}

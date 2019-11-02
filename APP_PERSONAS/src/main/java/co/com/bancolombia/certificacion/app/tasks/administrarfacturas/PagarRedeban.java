package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_PAGAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;

public class PagarRedeban implements Task {
    private Factura factura;

    public PagarRedeban(Factura factura) {
        this.factura = factura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                SeleccionarOpcionFactura.conInformacion(OPT_PAGAR_FACTURA, factura),
                Click.on(OPT_CUENTA_PRODUCTO.of(
                        factura.getProducto().getTipo(),
                        factura.getProducto().getNumero())
                ),
                Validar.carga(),
                Click.on(BTN_PAGAR),
                Validar.carga()
        );
    }
}
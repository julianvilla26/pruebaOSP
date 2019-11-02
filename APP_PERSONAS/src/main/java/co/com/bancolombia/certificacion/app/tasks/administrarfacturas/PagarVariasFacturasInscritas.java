package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_PAGAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.SELECCIONAR_TODAS;

public class PagarVariasFacturasInscritas implements Task {
    private Factura factura;
    private String opcion;

    public PagarVariasFacturasInscritas(String opcion,Factura factura) {
        this.factura = factura;
        this.opcion = opcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                SeleccionarOpcionFactura.conInformacion(OPT_PAGAR_FACTURA, factura),
                Click.on(LNK_SIGUIENTE),
                Click.on(OPT_CUENTA_PRODUCTO.of(
                        factura.getProducto().getTipo(),
                        factura.getProducto().getNumero()
                        )
                ),
                Validar.carga(),
                Esperar.unTiempo(3000),
                Check.whether(opcion.contains(SELECCIONAR_TODAS)).andIfSo(
                        RealizarScroll.hastaPosicionDeTarget(CHK_SELECCIONAR_TODAS_FACTURAS),
                        Click.on(CHK_SELECCIONAR_TODAS_FACTURAS)
                ).otherwise(
                        RealizarScroll.hastaPosicionDeTarget(CHk_SELECCIONAR_FACTURA.of(
                                factura.getValorFacturaReferenciaPago(),
                                factura.getFechaVencimiento(),
                                factura.getReferencia())),
                        Click.on(CHk_SELECCIONAR_FACTURA.of(
                                factura.getValorFacturaReferenciaPago(),
                                factura.getFechaVencimiento(),
                                factura.getReferencia()
                                )
                        )
                ),
                Click.on(LNK_SIGUIENTE),
                Click.on(BTN_PAGAR),
                Validar.carga()
        );
    }
}
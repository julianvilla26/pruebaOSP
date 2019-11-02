package co.com.bancolombia.certificacion.app.stepdefinitions.administrarfacturas;

import co.com.bancolombia.certificacion.app.exceptions.recaudos.PagoFacturaInscritaException;
import co.com.bancolombia.certificacion.app.exceptions.recaudos.PagoRedebanNoRealizadoException;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarPago;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarPagoFactura;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarPagoFacturaInscrita;
import co.com.bancolombia.certificacion.app.tasks.administrarfacturas.AdministrarFactura;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.recaudos.PagoFacturaInscritaException.NO_SE_PAGO_FACTURA_INSCRITA;
import static co.com.bancolombia.certificacion.app.exceptions.recaudos.PagoRedebanNoRealizadoException.PAGO_REDEBAN_NO_REALIZADO;
import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagarFacturasStepDefinition {

    @Cuando("el actor realizar el pago de sus facturas programadas con opcion (.*)$")
    public void elActorPagaSusFacturasProgramadas(String opcion, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionPagarProgramadas(
                opcion,
                factura().conValor(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conFechaFactura(datos)
                        .conReferencia(datos)
                        .conFechaVencimiento(datos)
                        .conValorFacturaReferencia(datos)
                )
        );
    }

    @Cuando("el actor realizar el pago de sus facturas inscritas con opcion (.*)$")
    public void elActorPagaSusFacturasInscritaConOpcion(String opcion, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionPagarVariasInscritas(
                opcion,
                factura().conValor(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conFechaFactura(datos)
                        .conReferencia(datos)
                        .conFechaVencimiento(datos)
                        .conValorFacturaReferencia(datos)
                )
        );
    }

    @Cuando("el actor realizar el pago de sus facturas inscritas$")
    public void elActorPagaSusFacturasInscritas(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionPagarInscritas(
                factura().conValor(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conFechaFactura(datos)
                        .conValorFacturaReferencia(datos)
                )
        );
    }

    @Cuando("el actor realizar el pago de sus factura redeban$")
    public void elActorPagaSusFacturasRedeban(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.pagoRedeban(
                factura().conValor(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conFechaFactura(datos)
                )
        );
    }

    @Entonces("^deberia ver el pago de redeban exitoso$")
    public void deberiaVerPagoRedeban() {
        theActorInTheSpotlight().should(seeThat(VerificarPago.redeban()).orComplainWith(PagoRedebanNoRealizadoException.class,PAGO_REDEBAN_NO_REALIZADO));
    }

    @Entonces("^deberia ver el pago de su factura programada$")
    public void deberiaVerPagoDeFacturaProgramada() {
        theActorInTheSpotlight().should(seeThat(VerificarPagoFactura.programada()).orComplainWith(PagoRedebanNoRealizadoException.class,PAGO_REDEBAN_NO_REALIZADO));
    }

    @Entonces("^deberia ver el pago de su factura inscrita$")
    public void deberiaVerHPagoFacturaInscrita() {
        theActorInTheSpotlight().should(seeThat(VerificarPagoFacturaInscrita.factura()).orComplainWith(PagoFacturaInscritaException.class,NO_SE_PAGO_FACTURA_INSCRITA));
    }
}
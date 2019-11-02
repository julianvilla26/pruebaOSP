package co.com.bancolombia.certificacion.app.stepdefinitions.administrarfacturas;

import co.com.bancolombia.certificacion.app.exceptions.recaudos.NoConsultaDetalleFacturaException;
import co.com.bancolombia.certificacion.app.exceptions.recaudos.NoConsultaFacturaException;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarConsultaDetalleFacturaInscritas;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarConsultaDetalleFacturaProgramada;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.VerificarConsultaFacturas;
import co.com.bancolombia.certificacion.app.tasks.administrarfacturas.AdministrarFactura;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.recaudos.NoConsultaDetalleFacturaException.NO_CONSULTA_DETALLE_FACTURAS;
import static co.com.bancolombia.certificacion.app.exceptions.recaudos.NoConsultaFacturaException.NO_CONSULTA_FACTURAS;
import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarDetalleFacturaStepDefinition {

    @Cuando("el actor revisa el detalle de su factura con informacion$")
    public void revisaDetalleDeSuFacturaConInformacion(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                AdministrarFactura.conOpcionConsultarDetalleFacturasInscritas(
                        factura().conEmpresaServicio(datos)
                                .conValor(datos)
                                .conFechaFactura(datos)
                                .conEmpresaServicio(datos)
                )
        );
    }

    @Cuando("el actor revisa el detalle de su factura programada con informacion$")
    public void revisaDetalleDeSuFacturaProgramadaInformacion(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                AdministrarFactura.conOpcionConsultarDetalleFacturasProgramadas(
                        factura().conEmpresaServicio(datos)
                                .conValor(datos)
                                .conFechaFactura(datos)
                                .conEmpresaServicio(datos)
                )
        );
    }

    @Cuando("el actor realiza la consulta de sus facturas inscritas$")
    public void revisaConsultaDeSusFacturasInscritas() {
        theActorInTheSpotlight().attemptsTo(
                AdministrarFactura.conOpcionConsultarFacturasInscritas()
        );
    }

    @Cuando("el actor realiza la consulta de sus facturas programadas$")
    public void revisaConsultaDeSusFacturasProgramadas() {
        theActorInTheSpotlight().attemptsTo(
                AdministrarFactura.conOpcionConsultarFacturasProgramadas()
        );
    }

    @Entonces("deberia ver el detalle de su factura programada$")
    public void deberiaVerDetalleFacturaProgramada() {
        theActorInTheSpotlight().should(seeThat(VerificarConsultaDetalleFacturaProgramada.exitoso()).orComplainWith(NoConsultaDetalleFacturaException.class, NO_CONSULTA_DETALLE_FACTURAS));
    }

    @Entonces("deberia ver el detalle de su factura inscrita$")
    public void deberiaVerDetalleFacturaInscrita() {
        theActorInTheSpotlight().should(seeThat(VerificarConsultaDetalleFacturaInscritas.inscritas()).orComplainWith(NoConsultaDetalleFacturaException.class, NO_CONSULTA_DETALLE_FACTURAS));
    }

    @Entonces("deberia ver consulta de sus facturas$")
    public void deberiaVerSusFacturaInscrita() {
        theActorInTheSpotlight().should(seeThat(VerificarConsultaFacturas.enFacturas()).orComplainWith(NoConsultaFacturaException.class, NO_CONSULTA_FACTURAS));
    }
}
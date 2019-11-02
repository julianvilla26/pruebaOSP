package co.com.bancolombia.certificacion.app.stepdefinitions.administrarfacturas;

import co.com.bancolombia.certificacion.app.exceptions.EliminacionFacturasException;
import co.com.bancolombia.certificacion.app.exceptions.ModificacionProgramacionException;
import co.com.bancolombia.certificacion.app.exceptions.VerificarInscripcionFactura;
import co.com.bancolombia.certificacion.app.exceptions.recaudos.HistoricoPagoException;
import co.com.bancolombia.certificacion.app.exceptions.recaudos.NoPresentaMensajeProgramacionExitosaException;
import co.com.bancolombia.certificacion.app.questions.administrarfacturas.*;
import co.com.bancolombia.certificacion.app.tasks.administrarfacturas.AdministrarFactura;
import co.com.bancolombia.certificacion.app.tasks.administrarfacturas.Inscribir;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.EliminacionFacturasException.MENSAJE_ELIMINACION;
import static co.com.bancolombia.certificacion.app.exceptions.ModificacionProgramacionException.MENSAJE_MODIFICACION;
import static co.com.bancolombia.certificacion.app.exceptions.VerificarInscripcionFactura.INSCRIPCION_FALLIDA;
import static co.com.bancolombia.certificacion.app.exceptions.recaudos.HistoricoPagoException.NO_TIENE_HISTORICO_DE_PAGOS;
import static co.com.bancolombia.certificacion.app.exceptions.recaudos.NoPresentaMensajeProgramacionExitosaException.NO_PRESENTA_MENSAJE_PROGRAMACION_EXITOSA;
import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AdministrarFacturasStepDefinition {

    @Cuando("^el actor programa sus facturas inscritas con informacion$")
    public void programaSusFacturasInscritasConInformacion(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionProgramar(
                factura()
                        .conValor(datos)
                        .conFechaFactura(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conPeriodicidad(datos)
                        .conNumeroIntento(datos)
                        .conMesProgramacion(datos)
                        .conDuracionProgramacion(datos)
                        .conFechaInicio(datos)
                        .conFechaFin(datos)
        ));
    }

    @Cuando("^inscribe una factura$")
    public void inscribirFacura(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Inscribir.facturas(factura().conConvenio(datos).conDescripcionFactura(datos).conReferencia(datos).conConvenio(datos))
        );
    }

    @Cuando("el actor revisa el historico de pagos de (.*) facturas$")
    public void revisaelHistoricoDeSuFacturasInscritas(String opcion, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conHistoricoPago(
                opcion,
                factura().conValor(datos)
                        .conFechaFactura(datos)
                        .conEmpresaServicio(datos)
                )
        );
    }

    @Cuando("el actor modifica descripcion de su factura inscrita$")
    public void modifcaDescripcionFacturasInscritas(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionEditarFacturaInscrita(
                factura().conValor(datos)
                        .conFechaFactura(datos)
                        .conEmpresaServicio(datos)
                        .conDescripcionFactura(datos)
                )
        );
    }

    @Cuando("el actor elimina su factura con opcion (.*) e informacion$")
    public void eliminaSusFacturasInscritas(String opcion, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionELiminar(
                factura().conValor(datos)
                        .conFechaFactura(datos)
                        .conEmpresaServicio(datos),
                opcion
                )
        );
    }

    @Cuando("el actor modifica sus facturas programadas por la opcion (.*)$")
    public void elActorModificaSusFacturasProgramadas(String opcion, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(AdministrarFactura.conOpcionEditar(
                factura().conValor(datos)
                        .conFechaFactura(datos)
                        .conFechaInicio(datos)
                        .conFechaFin(datos)
                        .conEmpresaServicio(datos)
                        .conProducto(datos)
                        .conNumeroIntento(datos)
                        .conPeriodicidad(datos)
                        .conMesProgramacion(datos),
                opcion
        ));
    }

    @Entonces("deberia ver modificacion descripcion exitosa$")
    public void deberiaModificacionExitosa() {
        theActorInTheSpotlight().should(seeThat(VerificarModificacionFacturaInscrita.exitoso())
                .orComplainWith(ModificacionProgramacionException.class, MENSAJE_MODIFICACION));
    }

    @Entonces("deberia ver el mensaje de modificacion exitosa$")
    public void deberiaVerMensajeModificacionExitosa() {
        theActorInTheSpotlight().should(seeThat(VerificarModificacionFacturaProgramadas.programadas())
                .orComplainWith(ModificacionProgramacionException.class, MENSAJE_MODIFICACION));
    }

    @Entonces("deberia ver el mensaje de eliminacion exitosa$")
    public void mensajeEliminacionExitosa() {
        theActorInTheSpotlight().should(seeThat(VerificarEliminacionFactura.exitoso()).orComplainWith(EliminacionFacturasException.class, MENSAJE_ELIMINACION));
    }

    @Entonces("^deberia ver el mensaje de confirmacion$")
    public void deberiaVisualzoarMensajeEnlace() {
        theActorInTheSpotlight().should(
                seeThat(VerificarInscripcion.factura()).orComplainWith(VerificarInscripcionFactura.class, INSCRIPCION_FALLIDA)
        );
    }

    @Entonces("^deberia ver el historico de pagos$")
    public void deberiaVerHistoricoPago() {
        theActorInTheSpotlight().should(
                seeThat(VerificarHistoricoPago.enFacturas()).orComplainWith(HistoricoPagoException.class, NO_TIENE_HISTORICO_DE_PAGOS)
        );
    }

    @Entonces("^el deberia ver el mensaje de programación exitosa$")
    public void deberiaVerMensajeProgramacionExitosa() {
        theActorInTheSpotlight().should(
                seeThat(VerificarProgramacion.deFactura()).orComplainWith(NoPresentaMensajeProgramacionExitosaException.class, NO_PRESENTA_MENSAJE_PROGRAMACION_EXITOSA)
        );
    }
}
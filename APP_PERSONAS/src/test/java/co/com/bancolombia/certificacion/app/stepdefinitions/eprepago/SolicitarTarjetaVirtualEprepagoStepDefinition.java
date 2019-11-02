package co.com.bancolombia.certificacion.app.stepdefinitions.eprepago;

import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoLaConsultaException;
import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoSolicitudEprepagoException;
import co.com.bancolombia.certificacion.app.questions.eprepago.SolicitudTarjetaVirtualEprepago;
import co.com.bancolombia.certificacion.app.questions.eprepago.UsuarioConEprepago;
import co.com.bancolombia.certificacion.app.tasks.eprepago.SolicitarEprepago;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoLaConsultaException.MENSAJE_CONSULTA_NO_REALIZADA;
import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoSolicitudEprepagoException.MENSAJE_E_PREPAGO_NO_SOLICITADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SolicitarTarjetaVirtualEprepagoStepDefinition {

    @Cuando("^acepta los terminos y cndiciones de solicitud$")
    public void quieroSolicitarUnaTarjetaEprepago(){
        theActorInTheSpotlight().attemptsTo(SolicitarEprepago.enLaAppBancolombia());
    }

    @Entonces("^el debe ver el mensaje de solicitud exitosa$")
    public void deboVerElMensajeDeSolicitudExitosa() {
        theActorInTheSpotlight().should(seeThat(SolicitudTarjetaVirtualEprepago.esExitosa())
                .orComplainWith(NoSeRealizoSolicitudEprepagoException.class, MENSAJE_E_PREPAGO_NO_SOLICITADA));
    }

    @Entonces("^el deberia ver el detalle de la e-prepago$")
    public void deboVerElMensajeRespectivoParaElUsuario() {
        theActorInTheSpotlight().should(seeThat(UsuarioConEprepago.enLaApp()).
                orComplainWith(NoSeRealizoLaConsultaException.class, MENSAJE_CONSULTA_NO_REALIZADA));
    }
}
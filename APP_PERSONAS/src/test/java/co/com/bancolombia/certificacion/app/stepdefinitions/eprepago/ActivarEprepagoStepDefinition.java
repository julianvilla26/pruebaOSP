package co.com.bancolombia.certificacion.app.stepdefinitions.eprepago;

import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoCanceloAccionEprepagoException;
import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoRealizoActivacionEprepagoException;
import co.com.bancolombia.certificacion.app.questions.eprepago.ActivacionEprepago;
import co.com.bancolombia.certificacion.app.questions.eprepago.CancelarAccionEprepago;
import co.com.bancolombia.certificacion.app.tasks.eprepago.Activar;
import co.com.bancolombia.certificacion.app.tasks.eprepago.CancelarActivacion;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoCanceloAccionEprepagoException.NO_CANCELO_ACCION_EPREPAGO;
import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoRealizoActivacionEprepagoException.NO_SE_REALIZO_ACTIVACION_EPREPAGO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ActivarEprepagoStepDefinition {

    @Cuando("^quiero activar una tarjeta e-prepago$")
    public void quieroActivarUnaTarjetaEprepago(){
        theActorInTheSpotlight().attemptsTo(Activar.ePrepago());
    }

    @Entonces("^el deberia de ver un mensaje de activación exitosa para su eprepago$")
    public void elDeberiaDeVerUnMensajeDeActivacionExitosaParaSuEprepago(){
        theActorInTheSpotlight().should(seeThat(ActivacionEprepago.esExitosa()).orComplainWith(NoRealizoActivacionEprepagoException.class, NO_SE_REALIZO_ACTIVACION_EPREPAGO));
    }

    @Cuando("^cancelo la activación de una tarjeta e-prepago$")
    public void canceloLaActivacionDeUnaTarjetaEprepago(){
        theActorInTheSpotlight().attemptsTo(CancelarActivacion.ePrepago());
    }

    @Entonces("^no se deberia realizar la accion$")
    public void elDeberiaVerUnMensajeDeCancelacion(){
        theActorInTheSpotlight().should(seeThat(CancelarAccionEprepago.esExitosa()).orComplainWith(NoCanceloAccionEprepagoException.class, NO_CANCELO_ACCION_EPREPAGO));
    }
}
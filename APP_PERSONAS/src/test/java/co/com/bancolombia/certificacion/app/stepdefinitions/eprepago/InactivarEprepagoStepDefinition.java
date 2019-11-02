package co.com.bancolombia.certificacion.app.stepdefinitions.eprepago;

import co.com.bancolombia.certificacion.app.exceptions.eprepago.InactivacionEprepagoNoRealizadaException;
import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoPresentaMensajeNumeroMaximoInactivacionesException;
import co.com.bancolombia.certificacion.app.questions.eprepago.InactivacionEprepago;
import co.com.bancolombia.certificacion.app.questions.eprepago.NumeroMaximoIntentosInactivacion;
import co.com.bancolombia.certificacion.app.tasks.eprepago.CancelarInactivacion;
import co.com.bancolombia.certificacion.app.tasks.eprepago.Inactivar;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.eprepago.InactivacionEprepagoNoRealizadaException.NO_SE_REALIZO_INACTIVACION;
import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoPresentaMensajeNumeroMaximoInactivacionesException.NO_PRESENTA_MENSAJE_NUMERO_MAXIMO_INACTIVACIONES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InactivarEprepagoStepDefinition {

    @Cuando("^inactiva la tarjeta$")
    public void quieroInactivarUnaTarjetaEprepago(){
        theActorInTheSpotlight().attemptsTo(Inactivar.ePrepago());
    }

    @Cuando("^cancelo la inactivacion e-prepago$")
    public void quieroCancelarInactivacion(){
        theActorInTheSpotlight().attemptsTo(CancelarInactivacion.ePrepago());
    }

    @Entonces("^deberia de ver un mensaje de inactivacion exitosa para su eprepago$")
    public void elDeberiaDeVerUnMensajeDeInactivacionExitosaParaSuEprepago(){
       theActorInTheSpotlight().should(seeThat(InactivacionEprepago.exitosa()).orComplainWith(InactivacionEprepagoNoRealizadaException.class, NO_SE_REALIZO_INACTIVACION));
    }

    @Entonces("^el deberia de ver un mensaje de maximo numero de intentos$")
    public void mensajeNumeroMaximoIntentosInactivacion(){
       theActorInTheSpotlight().should(seeThat(NumeroMaximoIntentosInactivacion.ePrepago()).orComplainWith(NoPresentaMensajeNumeroMaximoInactivacionesException.class, NO_PRESENTA_MENSAJE_NUMERO_MAXIMO_INACTIVACIONES));
    }
}

package co.com.bancolombia.certificacion.app.stepdefinitions.autenticacion;

import co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveBloqueadaNoVisualizadoException;
import co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveInvalidoNoVisualizadoException;
import co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeValidacionNoVisualizadoException;
import co.com.bancolombia.certificacion.app.questions.autenticacion.MensajeClaveInvalida;
import co.com.bancolombia.certificacion.app.questions.autenticacion.MensajeClaveValida;
import co.com.bancolombia.certificacion.app.questions.autenticacion.MensajeDeClaveBloqueada;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveBloqueadaNoVisualizadoException.MENSAJE_CLAVE_BLOQUEADA_NO_ENCONTRADO;
import static co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveInvalidoNoVisualizadoException.MENSAJE_PASS_INVALIDO_NO_ENCONTRADO;
import static co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeValidacionNoVisualizadoException.MENSAJE_VALIDACION_NO_ENCONTRADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticacionStepDefinition {

    @Entonces("^la autenticacion deberia de ser exitosa$")
    public void verificoElResultadoDeLaAutenticacionExitosa() {
        theActorInTheSpotlight().should(seeThat(MensajeClaveValida.esVisible())
                .orComplainWith(MensajeValidacionNoVisualizadoException.class,MENSAJE_VALIDACION_NO_ENCONTRADO));
    }

    @Entonces("^la autenticacion deberia de ser fallida por clave invalida$")
    public void verificoElResultadoDelLogueoFallido() {
        theActorInTheSpotlight().should(seeThat(MensajeClaveInvalida.esVisible())
                .orComplainWith(MensajeClaveInvalidoNoVisualizadoException.class,MENSAJE_PASS_INVALIDO_NO_ENCONTRADO));
    }

    @Entonces("^la autenticacion deberia de ser fallida por usuario bloqueado$")
    public void verificoElResultadoDelLogueoConUsuarioBloqueado() {
            theActorInTheSpotlight().should(seeThat(MensajeDeClaveBloqueada.esVisible())
                    .orComplainWith(MensajeClaveBloqueadaNoVisualizadoException.class,MENSAJE_CLAVE_BLOQUEADA_NO_ENCONTRADO));
    }
}
package co.com.bancolombia.certificacion.app.stepdefinitions.bloqueos;

import co.com.bancolombia.certificacion.app.exceptions.bloqueos.MensajeBloquoNoPresentadoException;
import co.com.bancolombia.certificacion.app.questions.bloqueos.VerificarBloqueo;
import co.com.bancolombia.certificacion.app.tasks.bloqueos.Bloquear;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.bloqueos.MensajeBloquoNoPresentadoException.MENSAJE_NO_PRESENTADO;
import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BloqueoStepDefinition {

    @Cuando("^quiere bloquear la tarjeta (.*) con numero (.*)$")
    public void bloquearTarjeta(String tipoTarjeta, String numeroTarjeta) {
        theActorInTheSpotlight().attemptsTo(
                Bloquear.tarjeta(elProducto().conTipoCuenta(tipoTarjeta).conNumero(numeroTarjeta))
        );
    }

    @Cuando("^quiere bloquear la clave$")
    public void bloquearClave() {
        theActorInTheSpotlight().attemptsTo(
                Bloquear.clave()
        );
    }

    @Cuando("^quiere bloquear la clave y tarjetas$")
    public void bloquearClaveTarjteas() {
        theActorInTheSpotlight().attemptsTo(
                Bloquear.claveTarjetas()
        );
    }

    @Cuando("^quiere bloquear la clave dinamica$")
    public void bloquearClaveDinamica() {
        theActorInTheSpotlight().attemptsTo(
                Bloquear.claveDinamica()
        );
    }

    @Entonces("^el deberia ver el mensaje de bloqueo exitoso$")
    public void verMensajeBloqueoExitoso() {
        theActorInTheSpotlight().should(
                seeThat(VerificarBloqueo.exitoso()).orComplainWith(MensajeBloquoNoPresentadoException.class, MENSAJE_NO_PRESENTADO)
        );
    }
}

package co.com.bancolombia.certificacion.app.stepdefinitions.billetera;

import co.com.bancolombia.certificacion.app.exceptions.billetera.NoSeActivoBilleteraException;
import co.com.bancolombia.certificacion.app.questions.billetera.ActivacionBilletera;
import co.com.bancolombia.certificacion.app.tasks.billetera.RegistrarBilletera;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.bancolombia.certificacion.app.exceptions.billetera.NoSeActivoBilleteraException.MENSAJE_BILLETERA_NO_ACTIVADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroBilleteraStepDefinition {

    @Y("^realiza la activacion de la billetera$")
    public void realizaActivacionBilletera() {
        theActorInTheSpotlight().attemptsTo(
                RegistrarBilletera.enApp()
        );
    }

    @Entonces("^El deberia de ver que la activacion de su billetera fue exitoso$")
    public void deberiaVerActivacionBilleteraExitoso() {
        theActorInTheSpotlight().should(seeThat(
                ActivacionBilletera.esExitosa()).orComplainWith(
                NoSeActivoBilleteraException.class, MENSAJE_BILLETERA_NO_ACTIVADA
                )
        );
    }
}
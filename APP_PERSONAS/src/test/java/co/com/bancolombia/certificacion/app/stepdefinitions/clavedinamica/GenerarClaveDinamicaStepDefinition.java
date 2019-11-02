package co.com.bancolombia.certificacion.app.stepdefinitions.clavedinamica;

import co.com.bancolombia.certificacion.app.exceptions.clavedinamica.UsuarioNoSeEncuentraInscritoParaClaveDinamicaException;
import co.com.bancolombia.certificacion.app.questions.clavedinamica.VerificarClaveDinamicaGenerada;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.app.exceptions.clavedinamica.UsuarioNoSeEncuentraInscritoParaClaveDinamicaException.USUARIO_NO_INSCRITO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GenerarClaveDinamicaStepDefinition {

    @Entonces("Yo deberia ver la clave dinamica de mi usuario (.*)")
    public void deberiaVerClaveDinamicaGenerada(String nombreUsuario) {
        theActorInTheSpotlight().should(seeThat(VerificarClaveDinamicaGenerada.existeAutomaticamente(nombreUsuario)).orComplainWith(
                UsuarioNoSeEncuentraInscritoParaClaveDinamicaException.class, USUARIO_NO_INSCRITO
        ));
    }
}

package co.com.bancolombia.certificacion.app.stepdefinitions.clavedinamica;

import co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoEliminaClaveDinamicaException;
import co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoInscritaCorrectamenteException;
import co.com.bancolombia.certificacion.app.questions.clavedinamica.VerificarEliminacionClaveDinamica;
import co.com.bancolombia.certificacion.app.questions.clavedinamica.VerificarInscripcionClaveDinamica;
import co.com.bancolombia.certificacion.app.tasks.clavedinamica.GestionarClaveDinamica;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoEliminaClaveDinamicaException.NO_ELIMINA_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoInscritaCorrectamenteException.NO_INCRIBE_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder.usuario;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarClaveDinamicaStepDefinition {

    @Y("quiere eliminar su clave dinamica con nombre personalizado (.*)$")
    public void gestionaInscripcionClaveDinamica(String datos) {
        theActorInTheSpotlight().attemptsTo(
                GestionarClaveDinamica.conDatosEliminacion(usuario()
                        .conNombrePersonalizado(datos)
                ));
    }

    @Entonces("Deberia de ver el mensaje de eliminacion exitosa$")
    public void deberiaDeVerElMensajeDeEliminacionExitosa() {
        theActorInTheSpotlight().should(seeThat(VerificarEliminacionClaveDinamica.exitosa()).orComplainWith(
                ClaveNoEliminaClaveDinamicaException.class, NO_ELIMINA_CLAVE_DINAMICA
        ));
    }
}
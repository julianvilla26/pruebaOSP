package co.com.bancolombia.certificacion.app.stepdefinitions.clavedinamica;

import co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoInscritaCorrectamenteException;
import co.com.bancolombia.certificacion.app.questions.clavedinamica.VerificarInscripcionClaveDinamica;
import co.com.bancolombia.certificacion.app.tasks.clavedinamica.GestionarClaveDinamica;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.clavedinamica.ClaveNoInscritaCorrectamenteException.NO_INCRIBE_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder.usuario;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InscripcionClaveDinamicaStepDefinition {

    @Y("gestiono la inscripcion de clave dinamica$")
    public void gestionaInscripcionClaveDinamica(List<Map<String,String>>datos){
        theActorInTheSpotlight().attemptsTo(GestionarClaveDinamica.conDatosInscripcion(usuario()
                .conNombrePersonalizado(datos)
                .conCorreo(datos)
                .conTipoCorreo(datos)
                .conNumeroCelular(datos).
                        conSegundaClave(datos)));
    }

    @Entonces("Yo deberia ver mis datos registrados en clave dinamica$")
    public void deberiaVerClaveDinamExitosa(){
        theActorInTheSpotlight().should(seeThat(VerificarInscripcionClaveDinamica.exitosa()).orComplainWith(
                ClaveNoInscritaCorrectamenteException.class, NO_INCRIBE_CLAVE_DINAMICA
        ));
    }
}
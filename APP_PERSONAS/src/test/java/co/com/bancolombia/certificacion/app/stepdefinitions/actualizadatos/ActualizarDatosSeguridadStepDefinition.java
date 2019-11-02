package co.com.bancolombia.certificacion.app.stepdefinitions.actualizadatos;

import co.com.bancolombia.certificacion.app.exceptions.datosseguridad.NoSeActualizaronDatosException;
import co.com.bancolombia.certificacion.app.questions.actualizardatos.VerificarActualizacionDatosSeguridad;
import co.com.bancolombia.certificacion.app.tasks.actualizardatos.ActualizarDatosSeguridad;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.datosseguridad.NoSeActualizaronDatosException.ACTUALIZACION_FALLODA;
import static co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder.usuario;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ActualizarDatosSeguridadStepDefinition {

    @Y("modifica sus datos con informacion$")
    public void modificaDatosSeguridadConInformacion(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                ActualizarDatosSeguridad.conInformacion(usuario()
                .conCorreo(datos)
                .conTipoCorreo(datos)
                .conNumeroCelular(datos)
        )
        );
    }

    @Entonces("Yo deberia ver mis datos actualizados exitosamente$")
    public void deberiaVerDatosActualizados() {
        theActorInTheSpotlight().should(seeThat(VerificarActualizacionDatosSeguridad.exitosa()).orComplainWith(
                NoSeActualizaronDatosException.class, ACTUALIZACION_FALLODA
        ));
    }
}
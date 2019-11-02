package co.com.bancolombia.certificacion.app.stepdefinitions.registro;

import co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveBloqueadaNoVisualizadoException;
import co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveInvalidoNoVisualizadoException;
import co.com.bancolombia.certificacion.app.exceptions.registro.PantallaRegistroNoPresenteException;
import co.com.bancolombia.certificacion.app.questions.autenticacion.MensajeDeClaveBloqueada;
import co.com.bancolombia.certificacion.app.questions.autenticacion.MensajeUsuarioYaRegistrado;
import co.com.bancolombia.certificacion.app.questions.registro.MensajeRegistro;
import co.com.bancolombia.certificacion.app.questions.registro.VerificarPantalla;
import co.com.bancolombia.certificacion.app.tasks.autenticacion.IniciarSesion;
import co.com.bancolombia.certificacion.app.tasks.menu.SeleccionarOpcion;
import co.com.bancolombia.certificacion.app.tasks.registro.Registrar;
import co.com.bancolombia.certificacion.app.tasks.registro.Registrarse;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveBloqueadaNoVisualizadoException.MENSAJE_CLAVE_BLOQUEADA_NO_ENCONTRADO;
import static co.com.bancolombia.certificacion.app.exceptions.autenticacion.MensajeClaveInvalidoNoVisualizadoException.MENSAJE_PASS_INVALIDO_NO_ENCONTRADO;
import static co.com.bancolombia.certificacion.app.exceptions.registro.PantallaRegistroNoPresenteException.MENSAJE_PANTALLA_REGISTRO_NO_VISIBLE;
import static co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder.credenciales;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroUsuarioStepDefinition {

    @Cuando("^quiere ingresar desde (.*) con el documento (.*) con clave (.*)$")
    public void quiereIngresarARegistrarseConElDocumentoConClave(String tipoTransaccion, String usuario, String clave) {
       theActorInTheSpotlight().attemptsTo(
               SeleccionarOpcion.delMenu(tipoTransaccion),
               IniciarSesion.con(credenciales()
                        .conNombreUsuario(usuario)
                        .conClave(clave))
        );
    }

    @Cuando("^quiere realizar el registro con el usuario (.*) y con el correo (.*)$")
    public void quiereRealizarElRegistroConElUsuarioYConElCorreo(String nuevoUser, String correoUser) {
        theActorInTheSpotlight().attemptsTo(
                Registrarse.conLosDatos(nuevoUser, correoUser));
    }

    @Entonces("^el deberia de ver un mensaje de registro exitoso$")
    public void verificoElResultadoDelRegistro() {
        theActorInTheSpotlight().should(seeThat(MensajeRegistro.exitoso()));
    }

    @Entonces("^el deberia de ver el mensaje usuario o clave invalida$")
    public void elDeberiaDeVerElMensajeUsuarioOClaveInvalida() {
        theActorInTheSpotlight().should(seeThat(MensajeUsuarioYaRegistrado.esVisible())
                .orComplainWith(MensajeClaveInvalidoNoVisualizadoException.class, MENSAJE_PASS_INVALIDO_NO_ENCONTRADO));
    }

    @Entonces("^el deberia de ver el mensaje de usuario bloqueado$")
    public void elDeberiaDeVerElMensajeDeUsuaioBloqueado() {
        theActorInTheSpotlight().should(seeThat(MensajeDeClaveBloqueada.esVisible())
                .orComplainWith(MensajeClaveBloqueadaNoVisualizadoException.class, MENSAJE_CLAVE_BLOQUEADA_NO_ENCONTRADO));
    }

    @Y("^quiere realizar el registro despues$")
    public void quiereRealizarElRegistroDespues() {
        theActorInTheSpotlight().attemptsTo(
                Registrar.nuevamenteUsuario()
        );
    }

    @Entonces("^el deberia ver la pantalla de registro luego de autenticarse con su identificacion$")
    public void mostrarseVerLaPantallaDeRegistro() {
        theActorInTheSpotlight().should(seeThat(
                VerificarPantalla.inicioRegistro()).orComplainWith(
                        PantallaRegistroNoPresenteException.class, MENSAJE_PANTALLA_REGISTRO_NO_VISIBLE
                )
        );
    }
}
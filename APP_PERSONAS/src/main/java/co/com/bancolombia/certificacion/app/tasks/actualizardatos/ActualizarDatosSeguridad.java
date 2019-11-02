package co.com.bancolombia.certificacion.app.tasks.actualizardatos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_ACTUALIZAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.userinterface.pages.datosseguridad.ActualizarDatosSeguridadPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.CHK_TIPO_CORREO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ActualizarDatosSeguridad implements Task {
    private Usuario usuario;

    public ActualizarDatosSeguridad(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Validar.carga(),
                WaitUntil.the(TXT_CORREO_ACTUALIZAR, isVisible()),
                Enter.theValue(usuario.getCorreo()).into(TXT_CORREO_ACTUALIZAR),
                Click.on(FOCO),
                Click.on(CHK_TIPO_CORREO.of(usuario.getTipoCorreo())),
                WaitUntil.the(LNK_SIGUIENTE, isEnabled()),
                Click.on(LNK_SIGUIENTE),
                Enter.theValue(usuario.getNumeroCelular()).into(TXT_NUMERO_ACTUALIZAR),
                Click.on(LNK_ACTUALIZAR)
        );
        actor.remember(NOMBRE_PERSONALIZADO_CLAVE_DINAMICA, usuario.getNombrePersonalizado());
        actor.remember(CORREO_CLAVE_DINAMICA, usuario.getCorreo());
        actor.remember(TIPO_CORREO_CLAVE_DINAMICA, usuario.getTipoCorreo());
        actor.remember(NUMERO_CELULAR, usuario.getNumeroCelular());
    }

    public static ActualizarDatosSeguridad conInformacion(UsuarioBuilder usuarioBuilder) {
        return instrumented(ActualizarDatosSeguridad.class, usuarioBuilder.build());
    }
}
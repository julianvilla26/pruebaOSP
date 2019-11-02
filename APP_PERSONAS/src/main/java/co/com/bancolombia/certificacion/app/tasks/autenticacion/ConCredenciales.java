package co.com.bancolombia.certificacion.app.tasks.autenticacion;

import co.com.bancolombia.certificacion.app.interactions.comunes.Escribir;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_AUTENTICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ConCredenciales implements Task {
    private Usuario usuario;

    public ConCredenciales(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(MODELO_DATOS_AUTENTICACION, usuario);
        actor.attemptsTo(
                Type.theValue(usuario.getNombreUsuario()).into(TXT_USUARIO),
                Click.on(LBL_HOLA_PROVISIONAL),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()),
                Click.on(BTN_CONTINUAR),
                Click.on(TXT_CLAVE_DIGITOS),
                Escribir.enCampoTexto(usuario.getClave()),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()),
                Click.on(BTN_CONTINUAR)
        );
    }
}
package co.com.bancolombia.certificacion.app.tasks.autenticacion;

import co.com.bancolombia.certificacion.app.interactions.comunes.Escribir;
import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.BTN_CONTINUAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.BTN_INSCRIBIR_DINAMICA_CLAVE;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ConDatos implements Task {
    private String usuario;
    private String clave;

    public ConDatos(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, BTN_INSCRIBIR_DINAMICA_CLAVE)).
                        andIfSo(Click.on(BTN_INSCRIBIR_DINAMICA_CLAVE)),
                Esperar.unTiempo(3000),
                Click.on(BTN_INGRESAR),
                WaitUntil.the(TXT_USUARIO, isEnabled()),
                Type.theValue(usuario).into(TXT_USUARIO),
                Click.on(LBL_HOLA_PROVISIONAL),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()),
                Click.on(BTN_CONTINUAR),
                Click.on(TXT_CLAVE_DIGITOS),
                Escribir.enCampoTexto(clave),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()),
                Click.on(BTN_CONTINUAR)
        );
    }
}

package co.com.bancolombia.certificacion.app.questions.autenticacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.LBL_USER_YA_REGISTRADO;

public class MensajeUsuarioYaRegistrado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_USER_YA_REGISTRADO.resolveFor(actor).waitUntilVisible().isVisible();
    }
    public static MensajeUsuarioYaRegistrado esVisible() {
        return new MensajeUsuarioYaRegistrado();
    }
}
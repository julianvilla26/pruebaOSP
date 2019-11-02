package co.com.bancolombia.certificacion.app.questions.bloqueos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_BLOQUEO_EXITOSO;

public class VerificarBloqueo implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_BLOQUEO_EXITOSO.resolveFor(actor).isVisible();
    }

    public static VerificarBloqueo exitoso(){
        return new VerificarBloqueo();
    }
}

package co.com.bancolombia.certificacion.app.questions.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.RegistroPage.LBL_VALIDACION_REGISTRO_OK;

public class MensajeRegistro implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_VALIDACION_REGISTRO_OK.resolveFor(actor).waitUntilVisible().isVisible();
    }

    public static MensajeRegistro exitoso(){
        return new MensajeRegistro();
    }
}
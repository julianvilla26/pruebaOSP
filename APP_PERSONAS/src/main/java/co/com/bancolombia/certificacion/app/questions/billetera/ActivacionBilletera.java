package co.com.bancolombia.certificacion.app.questions.billetera;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.billetera.BilleteraPage.LBL_ACTIVACION_EXITOSA;

public class ActivacionBilletera implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_ACTIVACION_EXITOSA.resolveFor(actor).isVisible();
    }

    public static ActivacionBilletera esExitosa(){
        return new ActivacionBilletera();
    }
}

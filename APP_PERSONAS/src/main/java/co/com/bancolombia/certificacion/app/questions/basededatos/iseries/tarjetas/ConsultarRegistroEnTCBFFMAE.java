package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsultarRegistroEnTCBFFMAE implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = false;
        //result = FachadaEprepago.verifyTheCreditOfTheCardEprepago(actor);
        return result;
    }
}

package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.terminos;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.terminos.Registro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsultarRegistroEnWWWFFLGTYC implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new Registro().verificoTerminosYCondiciones(actor);
    }
}

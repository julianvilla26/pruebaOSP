package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.transversal.Transversales;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsultarRegistroEnPCCFFPPCLI implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return new Transversales().verifyTopesPersonalizadosPCCFFPPCLI(actor);
    }


}

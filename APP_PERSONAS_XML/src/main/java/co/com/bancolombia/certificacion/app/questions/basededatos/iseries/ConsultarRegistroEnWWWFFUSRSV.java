package co.com.bancolombia.certificacion.app.questions.basededatos.iseries;


import co.com.bancolombia.certificacion.app.integration.FachadaRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsultarRegistroEnWWWFFUSRSV implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return new FachadaRegistro().verifyUserVirtual();
    }
}

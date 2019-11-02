package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.autenticacion;


import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.terminos.Registro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsultarRegistroEnWWWFFUSRSV implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return new Registro().verificoUsuarioVirtual(actor);
    }
}

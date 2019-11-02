package co.com.bancolombia.certificacion.app.questions.autenticacion;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.LBL_CLAVE_INVALIDA;

public class MensajeClaveValida implements Question<Boolean> {

    public static MensajeClaveValida esVisible() {
        return new MensajeClaveValida();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
            return !Verificar.elementoVisible(actor, LBL_CLAVE_INVALIDA);
    }
}

package co.com.bancolombia.certificacion.app.questions.eprepago;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.LBL_GENERARACION_EXITOSA;

public class ActivacionEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Verificar.elementoVisible(actor, LBL_GENERARACION_EXITOSA);
    }

    public static ActivacionEprepago esExitosa() {
        return new ActivacionEprepago();
    }
}
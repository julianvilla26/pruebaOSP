package co.com.bancolombia.certificacion.app.questions.ayuda;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.ayuda.AyudaPage.LBL_MENSAJE_PANTALLA;

public class Despliege implements Question<Boolean> {
    private String mensajePantalla;

    private Despliege(String mensajePantalla) {
        this.mensajePantalla = mensajePantalla;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_MENSAJE_PANTALLA.of(mensajePantalla).resolveFor(actor).isVisible();
    }

    public static Despliege vista(String mensajePantalla){
        return new Despliege(mensajePantalla);
    }
}

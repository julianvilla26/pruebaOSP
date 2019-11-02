package co.com.bancolombia.certificacion.app.questions.ayuda;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.ayuda.AyudaPage.LBL_TITULO_VISTA_WEB;

public class Visualizar implements Question<Boolean> {
    private String tituloPantalla;

    private Visualizar(String tituloPantalla) {
        this.tituloPantalla = tituloPantalla;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_TITULO_VISTA_WEB.of(tituloPantalla).resolveFor(actor).isVisible();
    }

    public static Visualizar enlaceWeb(String mensajePantalla){
        return new Visualizar(mensajePantalla);
    }
}

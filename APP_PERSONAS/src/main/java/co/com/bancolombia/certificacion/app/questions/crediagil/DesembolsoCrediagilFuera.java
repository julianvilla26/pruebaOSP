package co.com.bancolombia.certificacion.app.questions.crediagil;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.userinterface.pages.crediagil.CrediagilPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoHabilitado;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;

public class DesembolsoCrediagilFuera implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return elementoVisible(actor, TXT_FUERA_RANGO) &&
                !elementoHabilitado(actor, BTN_SIGUIENTE);
    }

    public static DesembolsoCrediagilFuera rango() {
        return new DesembolsoCrediagilFuera();
    }
}

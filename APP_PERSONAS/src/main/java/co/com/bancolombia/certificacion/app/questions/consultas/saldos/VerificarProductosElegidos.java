package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.TIENE_PRODUCTOS;

public class VerificarProductosElegidos implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean tieneProductosSeleccionados = actor.recall(TIENE_PRODUCTOS);
        return (tieneProductosSeleccionados);
    }

    public static VerificarProductosElegidos pertenecenAlUsuario() {
        return new VerificarProductosElegidos();
    }
}

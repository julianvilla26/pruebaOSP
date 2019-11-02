package co.com.bancolombia.certificacion.app.questions.eprepago;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.LBL_INACTIVACION_EXITOSA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.LBL_COMPROBATE_EPREPAGO;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;

public class InactivacionEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return elementoVisible(actor, LBL_INACTIVACION_EXITOSA) &&
                elementoVisible(actor, LBL_COMPROBATE_EPREPAGO);
    }

    public static InactivacionEprepago exitosa(){
        return new InactivacionEprepago();
    }
}

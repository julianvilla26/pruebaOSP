package co.com.bancolombia.certificacion.app.questions.cheque;

import co.com.bancolombia.certificacion.app.models.cheque.Cheque;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.cheque.ChequePage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CHEQUE;

public class VerificarContraorden implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Cheque cheque=actor.recall(MODELO_CHEQUE);
        return Visibility.of(LBL_CONTRAORDEN_EXITOSA).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_COMPROBANTE).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_NUMERO_CHEQUE.of(cheque.getNumeroCheque())).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_CUENTA_ASOCIADA.of(cheque.getProducto().getTipo(),cheque.getProducto().getNumero())).viewedBy(actor).asBoolean();
    }
    public static VerificarContraorden deCheque(){
        return new VerificarContraorden();
    }
}
package co.com.bancolombia.certificacion.app.questions.pagos;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_CUENTA_SIN_SALDO;

public class VerificarMensajeSin implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Verificar.elementoVisible(actor, LBL_CUENTA_SIN_SALDO);
    }

    public static VerificarMensajeSin saldo(){
        return new VerificarMensajeSin();
    }
}
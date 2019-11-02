package co.com.bancolombia.certificacion.app.questions.pagos;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.pagos.PagosPage.TXT_MAYOR_DEUDA;

public class VerificarMensajePagoMayor implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Verificar.elementoVisible(actor, TXT_MAYOR_DEUDA);
    }

    public static VerificarMensajePagoMayor aDeuda(){
        return new VerificarMensajePagoMayor();
    }
}

package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.LBL_COMPROBANTE_EXITOSA;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoPresente;

public class VerificarPago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return elementoPresente(actor, TXT_PAGO_REDEBAN_EXITOSO) &&
                elementoPresente(actor, LBL_COMPROBANTE_EXITOSA);
    }

    public static VerificarPago redeban() {
        return new VerificarPago();
    }
}

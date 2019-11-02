package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.LBL_COMPROBANTE_EXITOSA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.LBL_ELIMINACION_EXITOSA;

public class VerificarEliminacionFactura implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LBL_ELIMINACION_EXITOSA).viewedBy(actor).asBoolean()
                && Visibility.of(LBL_COMPROBANTE_EXITOSA).viewedBy(actor).asBoolean();
    }

    public static VerificarEliminacionFactura exitoso() {
        return new VerificarEliminacionFactura();
    }
}
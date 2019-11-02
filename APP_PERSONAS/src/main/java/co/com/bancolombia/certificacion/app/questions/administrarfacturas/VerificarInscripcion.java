package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_VERIFICACION;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.InscribirPage.LBL_INSCRIPCION_EXITOSA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class VerificarInscripcion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Factura factura = actor.recall(MODELO_FACTURA);
        return LBL_INSCRIPCION_EXITOSA.resolveFor(actor).isPresent() &&
                LBL_VERIFICACION.of(factura.getConvenio()).resolveFor(actor).isPresent() &&
                LBL_VERIFICACION.of(factura.getDescripcionFactura()).resolveFor(actor).isPresent() &&
                LBL_VERIFICACION.of(factura.getReferencia()).resolveFor(actor).isPresent();
    }

    public static VerificarInscripcion factura(){
        return new VerificarInscripcion();
    }
}

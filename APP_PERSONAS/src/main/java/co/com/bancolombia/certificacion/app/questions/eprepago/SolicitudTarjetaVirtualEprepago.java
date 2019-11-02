package co.com.bancolombia.certificacion.app.questions.eprepago;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.SolicitarTarjetaVirtualEprepagoPage.*;

public class SolicitudTarjetaVirtualEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_SOLICITUD_EPREPAGO_EXITOSA.resolveFor(actor).waitUntilVisible().isVisible() &&
                LBL_COMPROBANTE_SOLICITUD_EPREPAGO.resolveFor(actor).waitUntilVisible().isVisible() &&
                LBL_SALDO_DISPONIBLE_EPREPAGO.resolveFor(actor).waitUntilVisible().isVisible() &&
                LBL_TIPO_TARJETA_EPREPAGO.resolveFor(actor).waitUntilVisible().isVisible() &&
                LBL_FECHA_VENCIMIENTO_EPREPAGO.resolveFor(actor).waitUntilVisible().isVisible() &&
                LBL_CODIGO_CVC_EPREPAGO.resolveFor(actor).waitUntilVisible().isVisible();
    }

    public static SolicitudTarjetaVirtualEprepago esExitosa(){
        return new SolicitudTarjetaVirtualEprepago();
    }
}
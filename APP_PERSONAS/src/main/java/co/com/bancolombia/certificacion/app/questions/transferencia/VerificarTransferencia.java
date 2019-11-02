package co.com.bancolombia.certificacion.app.questions.transferencia;

import co.com.bancolombia.certificacion.app.models.transaccion.Transferencia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.transferencia.TransferenciaPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_TRANSFERENCIA;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class VerificarTransferencia implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Transferencia transferencia = actor.recall(MODELO_TRANSFERENCIA);
        return LBL_TRANFERENCIA_EXITOSA.resolveFor(actor).isVisible() &&
                LBL_CUENTA_ORIGEN.of(transferencia.getProductoOrigen().getTipo(), transferencia.getProductoOrigen().getNumero()).resolveFor(actor).isPresent() &&
                LBL_CUENTA_DESTINO.of(transferencia.getProductoDestino().getTipo(), transferencia.getProductoDestino().getNumero()).resolveFor(actor).isPresent()&&
                LBL_VALOR.of(darFormato(transferencia.getMonto())).resolveFor(actor).isPresent();
    }

    public static VerificarTransferencia exitosa() {
        return new VerificarTransferencia();
    }
}

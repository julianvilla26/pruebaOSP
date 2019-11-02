package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import co.com.bancolombia.certificacion.app.models.productos.Eprepago;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_EPREPAGO;

public class VerificarDetalleEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Eprepago eprepago = actor.recall(MODELO_EPREPAGO);
        return eprepago.getTipo() != null &&
                eprepago.getNumero() != null &&
                eprepago.getSaldo().getSaldoDisponible() != null &&
                eprepago.getFechaVencimiento() != null &&
                eprepago.getCvc() != null;
    }

    public static VerificarDetalleEprepago esExitoso() {
        return new VerificarDetalleEprepago();
    }
}

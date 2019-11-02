package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_HISTORICO_FACTURA;

public class VerificarHistoricoPago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Factura> factura = actor.recall(MODELO_HISTORICO_FACTURA);
        boolean lista=false;
        for (Factura f : factura) {
            lista = f.getReferencia() != null
                    && f.getValorFactura() != null
                    && f.getEstadoFactura() != null
                    && f.getFechaFactura() != null;
        }
        return lista;
    }

    public static VerificarHistoricoPago enFacturas() {
        return new VerificarHistoricoPago();
    }
}
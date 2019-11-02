package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class VerificarConsultaFacturas implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Factura> factura = actor.recall(MODELO_FACTURA);
        boolean lista = false;
        for (Factura f : factura) {
            lista = f.getValorFactura() != null
                    && f.getFechaFactura() != null
                    && f.getEmpresaServicio() != null
                    && f.getDescripcionFactura() != null;
        }
        return lista;
    }

    public static VerificarConsultaFacturas enFacturas() {
        return new VerificarConsultaFacturas();
    }
}
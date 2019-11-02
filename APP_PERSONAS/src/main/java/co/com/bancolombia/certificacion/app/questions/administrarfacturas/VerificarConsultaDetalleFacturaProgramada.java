package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CONSULTA_DETALLE_FACTURA;

public class VerificarConsultaDetalleFacturaProgramada implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Factura facturas = actor.recall(MODELO_CONSULTA_DETALLE_FACTURA);
        return facturas.getEstadoFactura() != null
                && facturas.getFechaFactura() != null
                && facturas.getNegocio() != null
                && facturas.getNitFactura() != null
                && facturas.getCanalInscripcionFactura() != null
                && facturas.getNumeroFactura() != null
                && facturas.getEmpresaServicio() != null
                && facturas.getProducto().getTipo() != null
                && facturas.getProducto().getNumero() != null
                && facturas.getFechaFin() != null
                && facturas.getFechaInicio() != null;
    }

    public static VerificarConsultaDetalleFacturaProgramada exitoso() {
        return new VerificarConsultaDetalleFacturaProgramada();
    }
}
package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;

public class VerificarDetalleProductoCreditos implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto producto = actor.recall(MODELO_DETALLE_PRODUCTO);
        return (producto.getTipo() != null
                && producto.getNumero() != null
                && producto.getCredito().getCapitalVigente() != null
                && producto.getCredito().getDeudaFechaCredito() != null
                && producto.getCredito().getFechaProximoPago() != null
                && producto.getCredito().getInteresesCorrientes() != null
                && producto.getCredito().getSaldoMora() != null
                && producto.getCredito().getInteresesMora() != null
                && producto.getCredito().getOtrosCargos() != null
                && producto.getCredito().getFechasDesembolso() != null
                && producto.getCredito().getValorDesembolso() != null);
    }

    public static VerificarDetalleProductoCreditos esExitoso() {
        return new VerificarDetalleProductoCreditos();
    }
}

package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;

public class VerificarDetalleProductoTarjetas implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto producto = actor.recall(MODELO_DETALLE_PRODUCTO);
        return (producto.getTipo() != null
                && producto.getNumero() != null
                && producto.getTarjetaCredito().getFechaLimitePago() != null
                && producto.getTarjetaCredito().getDeudaALaFechaEnPesos()!= null
                && producto.getTarjetaCredito().getDeudaTotalEnDolares() != null
                && producto.getTarjetaCredito().getAvancesDisponiblesEnPesos() != null);
    }

    public static VerificarDetalleProductoTarjetas esExitoso() {
        return new VerificarDetalleProductoTarjetas();
    }
}
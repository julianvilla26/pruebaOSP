package co.com.bancolombia.certificacion.app.questions.eprepago;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.cheque.ChequePage.LBL_CUENTA_ASOCIADA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.RECARGAR_EPREPAGO;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class RecargaTarjetaEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto producto = actor.recall(MODELO_PRODUCTO);
        String valorCargado = actor.recall(RECARGAR_EPREPAGO);
        return LBL_RECARGA_EXITOSA_EPREPAGO.resolveFor(actor).isPresent() &&
                LBL_COMPROBATE_EPREPAGO.resolveFor(actor).isPresent() &&
                LBL_CUENTA_ASOCIADA.of(producto.getTipo(), producto.getNumero()).resolveFor(actor).isPresent() &&
                LBL_VALOR_RECARGADO_EPREPAGO.of(darFormato(valorCargado)).resolveFor(actor).isPresent();
    }

    public static RecargaTarjetaEprepago exitosa() {
        return new RecargaTarjetaEprepago();
    }
}
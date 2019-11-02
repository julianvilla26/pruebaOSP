package co.com.bancolombia.certificacion.app.questions.eprepago;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.cheque.ChequePage.LBL_CUENTA_ASOCIADA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.RecargarTarjetaVirtualEprepagoPage.LBL_COMPROBATE_EPREPAGO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.DescargarTarjetaVirtualEprepagoPage.LBL_DESCARGA_EXITOSA_EPREPAGO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.DescargarTarjetaVirtualEprepagoPage.LBL_VALOR_DESCARGA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.TOTAL;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.DESCARGAR_EPREPAGO;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class DescargaTarjetaVirtualEprepago implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto producto = actor.recall(MODELO_PRODUCTO);
        String valorDescarga = actor.recall(DESCARGAR_EPREPAGO);
        return  ((TOTAL.equals(valorDescarga))?true:LBL_VALOR_DESCARGA.of(darFormato(valorDescarga)).resolveFor(actor).isPresent()) &&
                LBL_DESCARGA_EXITOSA_EPREPAGO.resolveFor(actor).isPresent() &&
                LBL_COMPROBATE_EPREPAGO.resolveFor(actor).isPresent() &&
                LBL_CUENTA_ASOCIADA.of(producto.getTipo(), producto.getNumero()).resolveFor(actor).isPresent();
    }

    public static DescargaTarjetaVirtualEprepago esExitosa(){
        return new DescargaTarjetaVirtualEprepago();
    }
}
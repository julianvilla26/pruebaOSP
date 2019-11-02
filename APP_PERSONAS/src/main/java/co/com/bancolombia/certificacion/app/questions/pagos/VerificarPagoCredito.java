package co.com.bancolombia.certificacion.app.questions.pagos;

import co.com.bancolombia.certificacion.app.models.productos.Credito;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LBL_VERIFICACION;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.PAGO_EXITOSO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.*;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class VerificarPagoCredito implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto productoDebitado = actor.recall(MODELO_DETALLE_PRODUCTO);
        Credito credito = actor.recall(MODELO_CREDITO);
        return Verificar.elementoPresente(actor, LBL_VERIFICACION.of(PAGO_EXITOSO)) &&
                Verificar.elementoPresente(actor, LBL_VERIFICACION.of(credito.getNumero())) &&
                Verificar.elementoPresente(actor, LBL_VERIFICACION.of(darFormato(credito.getValorPago()))) &&
                Verificar.elementoPresente(actor, LBL_VERIFICACION.of(productoDebitado.getNumero()));
    }

    public static VerificarPagoCredito exitoso(){
        return new VerificarPagoCredito();
    }
}

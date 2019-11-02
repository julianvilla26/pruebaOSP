package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoPresente;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class VerificarPagoFactura implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Factura factura = actor.recall(MODELO_FACTURA);
        return elementoPresente(actor, TXT_MENSAJE_PAGO_EXITOSO) &&
                elementoPresente(actor, LBL_PRODUCTO_PAGO.of(factura.getProducto().getTipo(), factura.getProducto().getTipo())) &&
                elementoPresente(actor, LBL_COMPROBANTE_EXITOSA);
    }

    public static VerificarPagoFactura programada() {
        return new VerificarPagoFactura();
    }
}

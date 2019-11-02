package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class VerificarPagoFacturaInscrita implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Factura factura = actor.recall(MODELO_FACTURA);
        return LBL_PAGO_EXITOSO_FACTURA.resolveFor(actor).isPresent() &&
                LBL_COMPROBANTE_EXITOSA.resolveFor(actor).isPresent() &&
                LBL_NUEVO_SALDO_DISPONIBLE.resolveFor(actor).isPresent() &&
                LBL_PRODUCTO_PAGO.of(factura.getProducto().getTipo(), factura.getProducto().getTipo()).resolveFor(actor).isPresent() &&
                LBL_VALOR_PAGADO.of(darFormato(factura.getValorFacturaReferenciaPago())).resolveFor(actor).isPresent();
    }

    public static VerificarPagoFacturaInscrita factura() {
        return new VerificarPagoFacturaInscrita();
    }
}

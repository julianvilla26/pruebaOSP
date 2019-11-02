package co.com.bancolombia.certificacion.app.questions.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.LBL_VERIFICACION_MODIFICACION_INSCRITA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class VerificarModificacionFacturaInscrita implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Factura factura= actor.recall(MODELO_FACTURA);
        String valor=factura.getValorFactura();
        String fecha=factura.getFechaFactura();
        String servicio=factura.getEmpresaServicio();
        String descripcion=factura.getDescripcionFactura();
        return Verificar.elementoPresente(actor, LBL_VERIFICACION_MODIFICACION_INSCRITA.of(valor,fecha,servicio, descripcion));
    }

    public static VerificarModificacionFacturaInscrita exitoso(){
        return new VerificarModificacionFacturaInscrita();
    }
}
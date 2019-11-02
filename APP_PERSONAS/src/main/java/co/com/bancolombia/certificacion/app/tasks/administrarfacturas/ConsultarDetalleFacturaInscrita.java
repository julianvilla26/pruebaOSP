package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ConsultaDetalleFacturaPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.OPT_VER_DETALLE_FACTURA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CONSULTA_DETALLE_FACTURA;

public class ConsultarDetalleFacturaInscrita implements Task {
    private Factura factura;

    public ConsultarDetalleFacturaInscrita(Factura factura) {
        this.factura = factura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarOpcionFactura.conInformacion(OPT_VER_DETALLE_FACTURA, factura)
        );
        actor.remember(MODELO_CONSULTA_DETALLE_FACTURA,
                factura()
                        .conEmpresaServicio(LBL_DETALLE_EMPRESA_SERVICIO.of(factura.getEmpresaServicio()).resolveFor(actor).getText())
                        .conValor(LBL_DETALLE_VALOR_PAGAR.of(factura.getValorFactura()).resolveFor(actor).getText())
                        .conFechaFactura(LBL_DETALLE_FECHA_VENCIMIENTO_FACTURA.of(factura.getFechaFactura()).resolveFor(actor).getText())
                        .conNit(LBL_DETALLE_NIT.resolveFor(actor).getText())
                        .conNegocio(LBL_DETALLE_NEGOCIO.resolveFor(actor).getText())
                        .conEstadoHistorico(LBL_DETALLE_ESTADO.resolveFor(actor).getText())
                        .conNumeroFactura(LBL_DETALLE_NUMERO_FACTURA.resolveFor(actor).getText())
                        .conCanalInscripcionFactura(LBL_DETALLE_CANAL_INSCRIPCION_FACTURA.resolveFor(actor).getText())
                        .build()
        );
    }
}
package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ConsultaDetalleFacturaPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.OPT_PROGRAMADAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CONSULTA_DETALLE_FACTURA;

public class ConsultarDetalleFacturaProgramada implements Task {
    Factura factura;

    public ConsultarDetalleFacturaProgramada(Factura factura) {
        this.factura = factura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                Click.on(OPT_PROGRAMADAS),
                RealizarScroll.hastaPosicionDeTarget(OPT_VER_DETALLE_FACTURA_PROGRAMADA.of(factura.getValorFactura(),
                        factura.getFechaFactura(),
                        factura.getEmpresaServicio())),
                Click.on(OPT_VER_DETALLE_FACTURA_PROGRAMADA.of(factura.getValorFactura(),
                        factura.getFechaFactura(),
                        factura.getEmpresaServicio())),
                        Validar.carga()
        );
        actor.remember(MODELO_CONSULTA_DETALLE_FACTURA,
                factura()
                       .conEmpresaServicio(LBL_DETALLE_EMPRESA_SERVICIO.of(factura.getEmpresaServicio()).resolveFor(actor).getText())
                        .conNit(LBL_DETALLE_NIT.resolveFor(actor).getText())
                        .conNegocio(LBL_DETALLE_NEGOCIO.resolveFor(actor).getText())
                        .conEstadoHistorico(LBL_DETALLE_ESTADO.resolveFor(actor).getText())
                        .conCanalInscripcionFactura(LBL_DETALLE_CANAL_INSCRIPCION_FACTURA.resolveFor(actor).getText())
                        .conFechaInicio(LBL_DETALLE_FECHA_INICIO.resolveFor(actor).getText())
                        .conFechaFin(LBL_DETALLE_FECHA_FIN.resolveFor(actor).getText())
                        .conNumeroFactura(LBL_DETALLE_NUMERO_FACTURA.resolveFor(actor).getText())
                        .conTipoCuenta(LBL_DETALLE_TIPO_CUENTA.resolveFor(actor).getText())
                        .conNumeroCuenta(LBL_DETALLE_NUMERO_CUENTA.resolveFor(actor).getText())
                        .build()
        );
    }
}
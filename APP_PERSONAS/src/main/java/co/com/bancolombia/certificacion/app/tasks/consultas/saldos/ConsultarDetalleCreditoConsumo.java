package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.models.builders.CreditoBuilder.credito;
import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static co.com.bancolombia.certificacion.app.models.builders.TarjetaCreditoBuilder.tarjetaCredito;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.LBL_DISPONIBLE_AVACE_PESOS;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.BTN_DETALLE_PRODUCTO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.CUENTA_ESPECIFICA_TARJETA_CREDITO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarDetalleCreditoConsumo implements Task {
    private String opcionCategoria;
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarDetalleCreditoConsumo(String opcionCategoria, String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.opcionCategoria = opcionCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcionCategoria),
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_TARJETA_CREDITO),
                Esperar.unTiempo(10000));
        actor.remember(MODELO_DETALLE_PRODUCTO, elProducto()
                .conNumero(numeroCuenta)
                .conTipoCuenta(tipoCuenta)
                .conCredito(
                        credito()
                                .conDeudaFechaCredito(LBL_DEUDA_FECHA_CREDITO.resolveFor(actor).getText())
                                .conCapitalVigente(LBL_CAPITAL_VIGENTE.resolveFor(actor).getText())
                                .conFechaProximoPago(LBL_FECHA_PROXIMO_PAGO.resolveFor(actor).getText())
                                .conInteresesCorrientes(LBL_INTERES_CORRIENTES.resolveFor(actor).getText())
                                .conSaldoMora(LBL_SALDO_MORA.resolveFor(actor).getText())
                                .conInteresesMora(LBL_INTERES_MORA.resolveFor(actor).getText())
                                .conOtrosCargos(LBL_OTROS_CARGOS.resolveFor(actor).getText())
                                .conFechasDesembolso(LBL_FECHA_DESEMBOLSO.resolveFor(actor).getText())
                                .conValorDesembolso(LBL_VALOR_DESEMBOLSO.resolveFor(actor).getText())
                                .build()
                ).build()
        );
    }
}

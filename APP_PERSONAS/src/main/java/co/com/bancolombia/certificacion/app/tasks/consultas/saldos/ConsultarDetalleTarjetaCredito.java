package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static co.com.bancolombia.certificacion.app.models.builders.TarjetaCreditoBuilder.tarjetaCredito;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.BTN_DETALLE_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.TARJETAS_CREDITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarDetalleTarjetaCredito implements Task {
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarDetalleTarjetaCredito(String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(TARJETAS_CREDITO.getCategoria()),
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_TARJETA_CREDITO),
                WaitUntil.the(BTN_DETALLE_PRODUCTO, isVisible()),
                Click.on(BTN_DETALLE_PRODUCTO),
                Esperar.unTiempo(2000));
        actor.remember(MODELO_DETALLE_PRODUCTO, elProducto()
                .conNumero(numeroCuenta)
                .conTipoCuenta(tipoCuenta)
                .conTarjetaCredito(
                        tarjetaCredito()
                                .conFechaProximoPago(LBL_FECHA_PROXIMO_PAGO.resolveFor(actor).getText())
                                .conDeudaFechaPesos(LBL_DEUDA_FECHA_PESOS.resolveFor(actor).getText())
                                .conDeudaFechaDolares(LBL_DEUDA_FECHA_DOLAR.resolveFor(actor).getText())
                                .conAvanceDisponiblePeso(LBL_DISPONIBLE_AVACE_PESOS.resolveFor(actor).getText()).
                                build()
                ).build()
        );
    }
}
package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static co.com.bancolombia.certificacion.app.models.builders.SaldoBuilder.saldo;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.CUENTAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarDetalleCuentaDeposito implements Task {
    private String opcionCategoria;
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarDetalleCuentaDeposito(String opcionCategoria, String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.opcionCategoria = opcionCategoria;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcionCategoria),
                Check.whether(!CUENTAS.equals(opcionCategoria)).
                        andIfSo(
                                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_TARJETA_CREDITO)
                        ).otherwise(
                        SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_PRODUCTO)
                ),
                WaitUntil.the(BTN_DETALLE_PRODUCTO, isVisible()),
                Click.on(BTN_DETALLE_PRODUCTO),
                Esperar.unTiempo(2000));
        actor.remember(MODELO_DETALLE_PRODUCTO, elProducto()
                .conNumero(numeroCuenta)
                .conTipoCuenta(tipoCuenta)
                .conSaldo(
                        saldo()
                                .conSaldoDisponible(LBL_SALDO_DISPONIBLE_DETALLE.resolveFor(actor).getText())
                                .conSaldoEnCanje(LBL_SALDO_CANJE_DETALLE.resolveFor(actor).getText())
                                .conSaldoTotal(LBL_SALDO_TOTAL_DETALLE.resolveFor(actor).getText())
                                .build())
                .build()
        );

        actor.attemptsTo(
                Esperar.unTiempo(8000)
        );
    }
}
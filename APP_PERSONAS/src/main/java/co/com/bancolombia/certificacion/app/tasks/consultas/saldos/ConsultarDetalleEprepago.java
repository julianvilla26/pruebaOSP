package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.bancolombia.certificacion.app.models.builders.EprepagoBuilder.eprepago;
import static co.com.bancolombia.certificacion.app.models.builders.SaldoBuilder.saldo;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_EPREPAGO;

public class ConsultarDetalleEprepago implements Task {
    private String opcionCategoria;
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarDetalleEprepago(String opcionCategoria, String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.opcionCategoria = opcionCategoria;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcionCategoria),
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_EPREPAGO),
                Validar.carga()
        );
        actor.remember(MODELO_EPREPAGO,
                eprepago()
                        .conTipoCuenta(tipoCuenta)
                        .conNumeroTarjeta(LBL_NUMERO_TARJETA.resolveFor(actor).getText())
                        .conSaldoDisponible(
                                saldo().conSaldoDisponible(LBL_SALDO_DISPONIBLE_E_PREPAGO.resolveFor(actor).getText()).build()
                        )
                        .conFechaVencimiento(LBL_FECHA_VENCIMIENTO.resolveFor(actor).getText())
                        .conCvc(LBL_CVC.resolveFor(actor).getText())
                        .build()
        );
    }
}

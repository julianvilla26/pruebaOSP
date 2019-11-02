package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.CUENTAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.OPCION_INVERSIONES;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarProductos implements Task {
    private String tipoCuenta;
    private String numeroCuenta;
    private OpcionCategoriaSaldosMovimientosEnum opcion;

    public ConsultarProductos(String opcionCategoria, String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.opcion = OpcionCategoriaSaldosMovimientosEnum.valueOf(opcionCategoria) ;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcion.getCategoria()),
                Check.whether(CUENTAS.equals(opcion.getCategoria()))
                        .andIfSo(
                                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_PRODUCTO)
                        ).otherwise(
                        SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_TARJETA_CREDITO)
                ),
                WaitUntil.the(BTN_MOVIMIENTO, isVisible()),
                Click.on(BTN_MOVIMIENTO)
        );
    }

    public static ConsultarProductos sinMovimientosConInformacion(String opcionCategoria, String tipoCuenta, String numeroCuenta) {
        return instrumented(ConsultarProductos.class, opcionCategoria, tipoCuenta, numeroCuenta);
    }
}
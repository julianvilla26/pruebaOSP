package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.MovimientoBuilder.movimiento;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_LISTA_MOVIMIENTOS;
import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.TARJETAS_CREDITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarMovimientosTarjetasInversiones implements Task {
    private String tipoCuenta;
    private String numeroCuenta;
    private String opcionCategoria;

    public ConsultarMovimientosTarjetasInversiones(String tipoCuenta, String numeroCuenta, String opcionCategoria) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.opcionCategoria = opcionCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcionCategoria),
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_TARJETA_CREDITO),
                WaitUntil.the(BTN_MOVIMIENTO, isVisible()),
                Click.on(BTN_MOVIMIENTO)
        );
        List<Movimiento> listaMovimiento = new ArrayList<>();
        int iterador = 1;
        while (Verificar.elementoVisible(actor, CONTENEDOR_MOVIMIENTOS_TARJETA.of(String.valueOf(iterador)))) {
            listaMovimiento.add(movimiento().
                    conFecha(LBL_FECHA_MOVIMIENTO_TARJETA_CREDITO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conDescripcion(LBL_DESCRIPCION_MOVIMIENTO_TARJETA_CREDITO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conValorMovimiento(LBL_SALDO_MOVIMIENTO_TARJETA_CREDITO.of(String.valueOf(iterador)).resolveFor(actor).getText()).build()
            );
            iterador++;
        }
        actor.remember(MODELO_LISTA_MOVIMIENTOS, listaMovimiento);
    }
}
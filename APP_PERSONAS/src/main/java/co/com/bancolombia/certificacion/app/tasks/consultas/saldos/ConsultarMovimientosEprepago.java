package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.MovimientoBuilder.movimiento;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.LBL_SALDO_MOVIMIENTO_TARJETA_CREDITO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_LISTA_MOVIMIENTOS;
import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.EPREPAGO;
import static co.com.bancolombia.certificacion.app.utilidades.enumeradores.OpcionCategoriaSaldosMovimientosEnum.TARJETAS_CREDITO;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.obtenerIteradorEprepago;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarMovimientosEprepago implements Task {
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarMovimientosEprepago(String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(EPREPAGO.getCategoria()),
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_EPREPAGO),
                Validar.carga(),
                WaitUntil.the(BTN_MOVIMIENTO, isVisible()),
                Click.on(BTN_MOVIMIENTO)
        );
        List<Movimiento> listaMovimiento = new ArrayList<>();
        int iterador = 1;
        while (Verificar.elementoPresente(actor, CONTENEDOR_MOVIMIENTOS_EPREPAGO.of(String.valueOf(obtenerIteradorEprepago(iterador))))) {
            listaMovimiento.add(movimiento().
                    conFecha(LBL_FECHA_MOVIMIENTO_EPREPAGO.of(String.valueOf(obtenerIteradorEprepago(iterador))).resolveFor(actor).getText())
                    .conDescripcion(LBL_DESCRIPCION_MOVIMIENTO_EPREPAGO.of(String.valueOf(obtenerIteradorEprepago(iterador))).resolveFor(actor).getText())
                    .conValorMovimiento(LBL_SALDO_MOVIMIENTO_EPREPAGO.of(String.valueOf(obtenerIteradorEprepago(iterador))).resolveFor(actor).getText()).build()
            );
            iterador++;
        }
        actor.remember(MODELO_LISTA_MOVIMIENTOS, listaMovimiento);
    }
}

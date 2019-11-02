package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.MovimientoBuilder.movimiento;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_LISTA_MOVIMIENTOS;
import static co.com.bancolombia.certificacion.app.utilidades.mobileobjectfinder.ElementFinder.getPlatformCapability;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarMovimientosCuentas implements Task {
    private String tipoCuenta;
    private String numeroCuenta;

    public ConsultarMovimientosCuentas(String tipoCuenta, String numeroCuenta) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int iterador;
        actor.attemptsTo(
                SeleccionarProducto.desdeSaldosMovimientos(tipoCuenta, numeroCuenta, CUENTA_ESPECIFICA_PRODUCTO)
        );
        if ("Android".equalsIgnoreCase(getPlatformCapability())){
          iterador= 0;
        }else {
            iterador=1;
        }
        List<Movimiento> listaMovimiento = new ArrayList<>();
        actor.attemptsTo(
                WaitUntil.the(CONTENEDOR_MOVIMIENTOS_CUENTA.of(String.valueOf(iterador)), isVisible())
        );
        while (Verificar.elementoPresente(actor, CONTENEDOR_MOVIMIENTOS_CUENTA.of(String.valueOf(iterador)))) {
            listaMovimiento.add(movimiento().
                    conFecha(LBL_FECHA_CUENTA_MOVIMIENTO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conDescripcion(LBL_DESCRIPCION_CUENTA_MOVIMIENTO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conValorMovimiento(LBL_SALDO_CUENTA_MOVIMIENTO.of(String.valueOf(iterador)).resolveFor(actor).getText()).build()
            );
            iterador++;
        }
        actor.remember(MODELO_LISTA_MOVIMIENTOS, listaMovimiento);
    }
}

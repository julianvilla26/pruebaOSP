package co.com.bancolombia.certificacion.app.tasks.consultas.saldos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarCategoria;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.models.builders.CrediagilBuilder.crediagil;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.detalleproductos.DetalleProductosPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CREDIAGIL;

public class ConsultaDetalleCrediagil implements Task {
    private String opcionCategoria;

    public ConsultaDetalleCrediagil(String opcionCategoria) {
        this.opcionCategoria = opcionCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarCategoria.deSaldosMovimientos(opcionCategoria),
                RealizarScroll.hastaPosicionDeTarget(LBL_SALDO_CREDIAGIL_MOVIMIENTOS),
                Click.on(LBL_SALDO_CREDIAGIL_MOVIMIENTOS),
                Esperar.unTiempo(4000)
        );
        actor.remember(MODELO_CREDIAGIL, crediagil()
                .deTipo(opcionCategoria)
                .conCupoDisponible(LBL_CUPO_DISPONIBLE.resolveFor(actor).getText())
                .conCupoAsignado(LBL_CUPO_ASIGNADO.resolveFor(actor).getText())
                .conCupoUtilizado(LBL_CUPO_UTILIZADO.resolveFor(actor).getText())
                .conCupoCanje(LBL_CUPO_EN_CANJE.resolveFor(actor).getText())
                .conCupoDisponibleSobrecupo(LBL_DISPONIBLE_SOBRECUPO.resolveFor(actor).getText())
                .conValorMaximoDesembolsar(LBL_MAXIMO_DESEMBOLSAR.resolveFor(actor).getText())
                .conValorMinimoDesembolsar(LBL_MINIMO_DESEMBOLSAR.resolveFor(actor).getText())
                .build()
        );
    }
}

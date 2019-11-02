package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.PERIODICIDAD;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.PRODUCTO_ORIGEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarProgramacion implements Task {
    private Factura programarFacturas;
    private String opcion;

    public EditarProgramacion(Factura programarFacturas, String opcion) {
        this.programarFacturas = programarFacturas;
        this.opcion = opcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                Click.on(OPT_PROGRAMADAS),
                SeleccionarOpcionFactura.conInformacion(OPT_MODIFICAR_PROGRAMACION, programarFacturas),
                Validar.carga(),
                Click.on(FOCO),
                Check.whether(PRODUCTO_ORIGEN.equals(opcion)).andIfSo(
                        RealizarScroll.hastaPosicionDeTarget(LNK_CAMBIAR_PRODUCTO),
                        Click.on(LNK_CAMBIAR_PRODUCTO),
                        Validar.carga(),
                        Click.on(OPT_MIS_PRODUCTOS),
                        Validar.carga(),
                        RealizarScroll.hastaPosicionDeTarget(OPT_CUENTA_PRODUCTO.of(programarFacturas.getProducto().getTipo(), programarFacturas.getProducto().getNumero())),
                        Click.on(OPT_CUENTA_PRODUCTO.of(programarFacturas.getProducto().getTipo(), programarFacturas.getProducto().getNumero()))
                )
        );
        if (PERIODICIDAD.equals(opcion)) {
            actor.attemptsTo(
                    RealizarScroll.hastaPosicionDeTarget(LNK_CAMBIAR_PERIODICIDAD),
                    Click.on(LNK_CAMBIAR_PERIODICIDAD),
                    Validar.carga()
            );
            actor.attemptsTo(
                    WaitUntil.the(LST_NUMERO_INTENTOS, isVisible()),
                    Click.on(LST_NUMERO_INTENTOS)
            );
            actor.attemptsTo(
                    WaitUntil.the(LST_INTENTOS_PAGO.of(programarFacturas.getNumeroIntento()), isEnabled()),
                    Click.on(LST_INTENTOS_PAGO.of(programarFacturas.getNumeroIntento())),
                    Click.on(BTN_CERRAR_NUMERO_INTENTOS),
                    RealizarScroll.hastaPosicionDeTarget(CHK_RANGO_FECHAS),
                    Click.on(CHK_RANGO_FECHAS),
                    RealizarScroll.hastaPosicionDeTarget(TXT_FECHA_INICIO_FIN),
                    Click.on(TXT_FECHA_INICIO_FIN)
            );
            while (!Verificar.elementoVisible(actor, LBL_MES.of(programarFacturas.getMesProgramacion()))) {
                actor.attemptsTo(Click.on(BTN_FLECHA_MES_SIGUIENTE));
            }
            String valorMes = LBL_VALOR_MES.of(programarFacturas.getMesProgramacion()).resolveFor(actor).getValue();
            actor.attemptsTo(
                    Click.on(LST_RANGO_FECHA.of(programarFacturas.getFechaInicio(), valorMes)),
                    Click.on(LST_RANGO_FECHA.of(programarFacturas.getFechaFin(), valorMes)),
                    Click.on(BTN_SELECCIONAR),
                    Click.on(LNK_SIGUIENTE)
            );
        }
        actor.attemptsTo(
                Validar.carga(),
                Click.on(BTN_MODIFICAR));
        Validar.carga();
    }
}
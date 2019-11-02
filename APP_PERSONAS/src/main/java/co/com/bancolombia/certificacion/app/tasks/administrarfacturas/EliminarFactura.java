package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.INSCRITAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.SERVICIO;

public class EliminarFactura implements Task {
    private Factura programarFacturas;
    private String opcion;

    public EliminarFactura(Factura programarFacturas, String opcion) {
        this.programarFacturas = programarFacturas;
        this.opcion = opcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                Check.whether(!INSCRITAS.equalsIgnoreCase(opcion.toUpperCase())).andIfSo(
                        Click.on(OPT_PROGRAMADAS)
                ),
                SeleccionarOpcionFactura.conInformacion(OPT_ELIMINAR_FACTURA, programarFacturas),
                Click.on(BTN_CONFIRMAR_ELIMINACION),
                Validar.carga()
        );
        actor.remember(SERVICIO, programarFacturas.getEmpresaServicio());
    }
}
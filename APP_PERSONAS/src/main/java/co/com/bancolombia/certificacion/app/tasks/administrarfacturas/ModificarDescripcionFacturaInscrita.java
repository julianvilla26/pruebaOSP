package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class ModificarDescripcionFacturaInscrita implements Task {
    private Factura programarFacturas;

    public ModificarDescripcionFacturaInscrita(Factura programarFacturas) {
        this.programarFacturas = programarFacturas;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                SeleccionarOpcionFactura.conInformacion(OPT_MODIFICAR_DESCRIPCION, programarFacturas),
                Validar.carga());
        actor.attemptsTo(
                Clear.field(TXT_DESCRIPCION_FACTURA),
                Enter.theValue(programarFacturas.getDescripcionFactura()).into(TXT_DESCRIPCION_FACTURA),
                Click.on(TXT_FOCO_MODIFICAR_DESCRIPCION),
                Click.on(BTN_MODIFICAR),
                Validar.carga()
        );
        actor.remember(MODELO_FACTURA, programarFacturas);
    }
}
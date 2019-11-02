package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AdministrarFactura {

    public static Performable conOpcionProgramar(FacturaBuilder programarFacturasBuilder) {
        return instrumented(ProgramarFactura.class, programarFacturasBuilder.build());
    }

    public static Performable conOpcionEditar(FacturaBuilder programarFacturasBuilder, String opcion) {
        return instrumented(EditarProgramacion.class, programarFacturasBuilder.build(), opcion);
    }

    public static Performable conOpcionELiminar(FacturaBuilder programarFacturasBuilder, String opcion) {
        return instrumented(EliminarFactura.class, programarFacturasBuilder.build(), opcion);
    }

    public static Performable conOpcionConsultarDetalleFacturasInscritas(FacturaBuilder programarFacturasBuilder) {
        return instrumented(ConsultarDetalleFacturaInscrita.class, programarFacturasBuilder.build());
    }

    public static Performable conOpcionConsultarDetalleFacturasProgramadas(FacturaBuilder programarFacturasBuilder) {
        return instrumented(ConsultarDetalleFacturaProgramada.class, programarFacturasBuilder.build());
    }

    public static Performable conOpcionConsultarFacturasInscritas() {
        return instrumented(ConsultarFacturaInscritas.class);
    }

    public static Performable conOpcionConsultarFacturasProgramadas() {
        return instrumented(ConsultarFacturaProgramadas.class);
    }

    public static Performable conHistoricoPago(String opcion,FacturaBuilder programarFacturasBuilder) {
        return instrumented(HistoricoPago.class,opcion,programarFacturasBuilder.build());
    }

public static Performable conOpcionEditarFacturaInscrita(FacturaBuilder programarFacturasBuilder) {
        return instrumented(ModificarDescripcionFacturaInscrita.class,programarFacturasBuilder.build());
    }

    public static Performable conOpcionPagarProgramadas(String opcion, FacturaBuilder opcionFacturaBuilder) {
        return instrumented(PagarFacturaProgramada.class, opcion, opcionFacturaBuilder.build());
    }

    public static Performable conOpcionPagarInscritas( FacturaBuilder opcionFacturaBuilder) {
        return instrumented(PagarFacturaInscrita.class,opcionFacturaBuilder.build());
    }

 public static Performable conOpcionPagarVariasInscritas(String opcion, FacturaBuilder opcionFacturaBuilder) {
        return instrumented(PagarVariasFacturasInscritas.class,opcion,opcionFacturaBuilder.build());
    }

    public static Performable pagoRedeban( FacturaBuilder opcionFacturaBuilder) {
        return instrumented(PagarRedeban.class,opcionFacturaBuilder.build());
    }

    private AdministrarFactura() {
    }
}
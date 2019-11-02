package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadInversionVirtual;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosInversionVirtual implements Task {

    private final List<String> datos;

    public CargarDatosInversionVirtual(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosInversionVirtual enApp(List<String> datos) {
        return instrumented(CargarDatosInversionVirtual.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadInversionVirtual.conEstos(datos);
    }
}


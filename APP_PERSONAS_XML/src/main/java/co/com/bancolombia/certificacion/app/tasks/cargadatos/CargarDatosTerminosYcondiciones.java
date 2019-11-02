package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTerminos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosTerminosYcondiciones implements Task {

    private final List<String> datos;

    public CargarDatosTerminosYcondiciones(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosTerminosYcondiciones enApp(List<String> datos) {
        return instrumented(CargarDatosTerminosYcondiciones.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadTerminos.conEstos(datos);
    }
}


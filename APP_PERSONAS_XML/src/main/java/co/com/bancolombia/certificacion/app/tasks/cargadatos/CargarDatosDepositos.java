package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadDepositos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosDepositos implements Task {

    private final List<String> datos;

    public CargarDatosDepositos(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosDepositos enApp(List<String> datos) {
        return instrumented(CargarDatosDepositos.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadDepositos.conEstos(datos);
    }
}


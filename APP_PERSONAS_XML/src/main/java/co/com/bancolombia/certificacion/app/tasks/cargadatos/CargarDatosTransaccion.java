package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosTransaccion implements Task {

    private final List<String> datos;

    public CargarDatosTransaccion(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosTransaccion enApp(List<String> datos) {
        return instrumented(CargarDatosTransaccion.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadTransaccion.conEstos(datos);
    }
}


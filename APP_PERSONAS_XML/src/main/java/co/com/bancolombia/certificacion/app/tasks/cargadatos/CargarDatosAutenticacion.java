package co.com.bancolombia.certificacion.app.tasks.cargadatos;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Transaction transaccionCon task.
 */
public class CargarDatosAutenticacion implements Task {

    private final List<String> datos;

    public CargarDatosAutenticacion(List<String> datos) {
        this.datos = datos;
    }

    public static CargarDatosAutenticacion enApp(List<String> datos) {
        return instrumented(CargarDatosAutenticacion.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CargarEntidadUsuario.conEstos(datos);
    }
}


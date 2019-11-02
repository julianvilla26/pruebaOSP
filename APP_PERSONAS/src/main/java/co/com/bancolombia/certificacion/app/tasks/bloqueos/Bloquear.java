package co.com.bancolombia.certificacion.app.tasks.bloqueos;

import co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder;
import net.serenitybdd.screenplay.Performable;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_TASK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Bloquear {
    public static Performable claveDinamica() {
        return instrumented(ClaveDinamica.class);
    }

    public static Performable clave() {
        return instrumented(Clave.class);
    }

    public static Performable claveTarjetas() {
        return instrumented(TarjetasClave.class);
    }

    public static Performable tarjeta(ProductoBuilder producto) {
        return instrumented(Tarjeta.class, producto.build());
    }

    private Bloquear() {
        throw new IllegalStateException(CLASE_TASK);
    }
}

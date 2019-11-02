package co.com.bancolombia.certificacion.app.tasks.clavedinamica;

import co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GestionarClaveDinamica {

    public static Performable conDatosInscripcion(UsuarioBuilder usuarioBuilder) {
        return instrumented(InscribirClaveDinamica.class, usuarioBuilder.build());
    }

    public static Performable conDatosEliminacion(UsuarioBuilder usuarioBuilder) {
        return instrumented(EliminarClaveDinamica.class, usuarioBuilder.build());
    }
}
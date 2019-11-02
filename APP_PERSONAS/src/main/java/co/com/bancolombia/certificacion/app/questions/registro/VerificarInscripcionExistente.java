package co.com.bancolombia.certificacion.app.questions.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionProductoPage.LBL_CUENTA_PENDIENTE_CONFIRMACION;

public class VerificarInscripcionExistente implements Question<Boolean> {
    private String mensaje;

    public VerificarInscripcionExistente(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LBL_CUENTA_PENDIENTE_CONFIRMACION.of(mensaje)).viewedBy(actor).asBoolean();
    }

    public static VerificarInscripcionExistente deProductos(String mensaje) {
        return new VerificarInscripcionExistente(mensaje);
    }
}